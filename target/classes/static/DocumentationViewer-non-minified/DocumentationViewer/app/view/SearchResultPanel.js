Ext.define('DocumentationViewer.view.SearchResultPanel',{
	extend : 'Ext.grid.Panel',
	requires : [
		'DocumentationViewer.model.SearchResultViewModel'
	],
	alias : 'widget.searchResultsPanel',
	viewModel : 'searchResultViewModel',
	bind : {
		title : '{query} in {queryTime} ms',
		store : '{searchResultStore}'
	},
	viewConfig : {
		emptyText : '<html><div style="padding: 10px;color: gray;background-color: beige;font: bold 13px helvetica, arial, verdana, sans-serif;">No results...</div></html>',
		deferEmptyText: false
	},
	width : 250,
	hideHeaders : true,
	columns : [
		{
			dataIndex : 'formattedDisplay',
			flex : 1
		}
	],
	listeners : {
		select : 'onExtJSClassSelect'
	},
	initComponent : function()
	{
		this.callParent( arguments );
	}
});