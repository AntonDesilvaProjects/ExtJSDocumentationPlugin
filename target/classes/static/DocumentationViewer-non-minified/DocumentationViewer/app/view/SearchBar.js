Ext.define('DocumentationViewer.view.SearchBar',{
	extend : 'Ext.container.Container',
	alias : 'widget.searchBar',
	layout : {
		type : 'hbox',
		pack : 'center'
	},
	padding : 10,
	initComponent : function()
	{
		var me = this;
		me.searchTextField = Ext.widget('textfield',{
			itemId : 'searchTextField',
			emptyText : 'Enter query here...',
			padding : '0 5 0 0',
			enableKeyEvents : true,
			listeners : {
				keydown : function( textField, event, eOpts )
				{
					console.log( event.parentEvent.keyCode );
					if( event.parentEvent.keyCode === 13 )
						me.onBtnSearchClick( me.btnSearch, null );
				}
			}
		});
		me.btnSearch = Ext.widget('button',{
			itemId: 'btnSearch',
			text : 'Search',
			handler : me.onBtnSearchClick
		});

		me.items = [
			me.searchTextField,
			me.btnSearch
		];

		this.callParent( arguments );
	},
	onBtnSearchClick : function( btn, eOpts )
	{
		var query = btn.up().down('#searchTextField').getValue();
		Ext.Ajax.request({
			url : 'http://localhost:3000/DocumentationServer/ui/getDocumentation',
			method : 'GET',
			params : {
				q : query
			},
			success : null,
			failure : function()
			{
				console.log('query search failed!');
			}
		});
	}
});