Ext.define('DocumentationViewer.model.SearchResultViewModel',{
	extend : 'Ext.app.ViewModel',
	alias : 'viewmodel.searchResultViewModel',
	requires : [
		'DocumentationViewer.model.SearchResultModel'
	],
	data : {
		query  : '',
		queryTime : 0
	},
	stores : {
		searchResultStore : {
			model : 'DocumentationViewer.model.SearchResultModel',
			data : []
		}
	}
});