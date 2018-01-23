Ext.define('DocumentationViewer.model.SearchResultModel',{
	extend : 'Ext.data.Model',
	fields : [
		{
			name : 'className',
			type : 'string'
		},
		{
			name : 'alias',
			type : 'auto'
		},
		{
			name : 'url',
			type : 'string'
		},
		{
			name : 'formattedDisplay',
			convert : function( value, record )
			{
				var displayText = record.get('className');
				if( record.get('alias') && record.get('alias').length != 0 )
					displayText += '(' + record.get('alias') + ')';
				return displayText;
			}
		}
	]
});