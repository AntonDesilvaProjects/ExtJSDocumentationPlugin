Ext.define('DocumentationViewer.controller.DocumentationController',{
	extend : 'Ext.app.ViewController',
	alias : 'controller.documentationController',
	POLLER_INTERVAL : 2000,
	init : function()
	{
		var me = this;
		me.searchResultsPanel = me.lookupReference('searchResultsPanel');
		me.documentView = me.lookupReference('documentView');

		me.startPollerProcess();
		this.callParent(arguments);
	},
	startPollerProcess : function()
	{
		var me = this;
		me.taskRunner = new Ext.util.TaskRunner();
		me.docPollerTask = me.taskRunner.newTask({
			run : me.getLatestQueryResults.bind(me), //bind is an alternative to 'scope' below
			interval : me.POLLER_INTERVAL,
			//scope : me
		});
		me.docPollerTask.start();
	},
	getLatestQueryResults : function()
	{
		console.log('querying the API...');

		var me = this;
		Ext.Ajax.request({
			url : 'http://localhost:3000/DocumentationServer/ui/poller',
			method : 'GET',
			success : me.onQueryResults.bind(me),
			failure : function()
			{
				console.log('cannot retrieve the latest query data....');
			}
		});
	},
	onQueryResults : function( response )
	{
		var me = this;
		var responseObj = Ext.JSON.decode( response.responseText, true );
		if( responseObj )
		{
			var query = responseObj.query;
			var queryTime = responseObj.queryTime;
			var searchResults = responseObj.searchResults;

			if( !Ext.isEmpty( query ) && queryTime !== -1.0 )
			{
				var searchResultsVM = me.searchResultsPanel.getViewModel();
				searchResultsVM.set( 'query', query );
				searchResultsVM.set( 'queryTime', queryTime );

				var resultArr = [];

				Ext.Array.forEach( searchResults, function( result ) {

					var resultObj = result.match;
					var modelData = {
						'className' : resultObj.documentedClass.name,
						'alias' :  resultObj.documentedClass.alias,
						'url' : resultObj.url
					};
					var searchResultModel = Ext.create('DocumentationViewer.model.SearchResultModel', modelData );
					resultArr.push( searchResultModel );
				});

				searchResultsVM.getStore('searchResultStore').loadData( resultArr, false );
				me.searchResultsPanel.getSelectionModel().select( searchResultsVM.getStore('searchResultStore').getAt(0), false, false );
			}
		}
	},
	onExtJSClassSelect : function( grid, record, eOpts )
	{
		var me = this;
		me.documentView.loadDocument( record.get('url') );
	}
});