Ext.define('DocumentationViewer.view.DocumentView',{
	extend : 'Ext.panel.Panel',
	requires : [
		'Ext.ux.IFrame'
	],
	alias : 'widget.documentView',
	layout : {
		type : 'vbox',
		align : 'stretch'
	},
	initComponent : function()
	{
		var me = this;
		var docViewFrame = Ext.widget('uxiframe',{
			itemId : 'docViewFrame',
			src : '/docs/index.html',
			height : 800,
			padding : 5
		});

		me.items = [
			docViewFrame
		];
		this.callParent( arguments );
	},
	loadDocument : function( src )
	{
		var me = this;
		me.down('#docViewFrame').load( src );
	}
});