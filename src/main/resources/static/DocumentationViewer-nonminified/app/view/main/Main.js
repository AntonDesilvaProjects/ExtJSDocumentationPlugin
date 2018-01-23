Ext.define('DocumentationViewer.view.main.Main', {
    extend: 'Ext.container.Container',
    requires: [
        'DocumentationViewer.view.main.MainController',
        'DocumentationViewer.view.main.MainModel',
        'DocumentationViewer.view.SearchResultPanel',
        'DocumentationViewer.controller.DocumentationController',
        'DocumentationViewer.view.DocumentView',
        'DocumentationViewer.view.SearchBar'
    ],

    xtype: 'app-main',
    referenceHolder : true,
    
    controller: 'documentationController',
    viewModel: {
        type: 'main'
    },

    layout: {
        type: 'border'
    },

    items: [
        {
            xtype : 'searchBar',
            height : 50,
            region : 'north'
        },
        {
            xtype : 'searchResultsPanel',
            reference : 'searchResultsPanel',
            region : 'west',
            collapsible : true
        },
        {
            xtype : 'documentView',
            reference : 'documentView',
            region : 'center',
            border : 1
        }
    ]
});
