Ext.define('DocumentationViewer.store.SearchResultStore',{
	extend : 'Ext.data.Store',
	// /alias : 'store.searchResultStore',
	model : 'DocumentationViewer.model.SearchResultModel',
	data : [
		{
			"className" : 'Ext.button.Button',
			"alias" : [
				"button",
				"btn"
			]
		}
	]
});