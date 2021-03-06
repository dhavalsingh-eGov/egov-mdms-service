var dat = {
	"wc.create": {
		"numCols": 12/3,
		"url": "/wcms/masters/propertytype-usagetype/_create",
		"tenantIdRequired": true,
		"idJsonPath": "PropertyTypeUsageTypes[0].id",
		"useTimestamp": true,
		"objectName": "PropertyTypeUsageType",
		"groups": [
			{
				"label": "wc.create.propertyUsage.title",
				"name": "propertyUsage",
				"fields": [
					{
						"name": "propertyType",
						"jsonPath": "PropertyTypeUsageType[0].propertyType",
						"label": "wc.create.propertyType",
						"pattern": "",
						"type": "singleValueList",
						"url": "/pt-property/property/propertytypes/_search?&active=true|$..name|$..name",
						"isRequired": true,
						"isDisabled": false,
						"requiredErrMsg": "",
						"patternErrMsg": ""
					},
					{
						"name": "usageType",
						"jsonPath": "PropertyTypeUsageType[0].usageType",
						"label": "wc.create.usageType",
						"pattern": "",
						"type": "singleValueList",
						"url": "/pt-property/property/usages/_search?&active=true|$..name|$..name",
						"isRequired": true,
						"isDisabled": false,
						"requiredErrMsg": "",
						"patternErrMsg": ""
					},
						{
							"name": "Active",
							"jsonPath": "PropertyTypeUsageType[0].active",
							"label": "Active",
							"pattern": "",
							"type": "checkbox",
							"isRequired": false,
							"isDisabled": false,
							"defaultValue":true,
							"requiredErrMsg": "",
							"patternErrMsg": ""
						}
				]
			}
		]
	},
	"wc.search": {
		"numCols": 12/3,
		"url": "/wcms/masters/propertytype-usagetype/_search",
		"tenantIdRequired": true,
		"useTimestamp": true,
		"objectName": "PropertyTypeUsageType",
		"groups": [
			{
				"label": "wc.search.PropertyTypeUsageType.title",
				"name": "searchPropertyTypeUsageType",
				"fields": [
					{
						"name": "propertyType",
						"jsonPath": "propertyType",
						"label": "wc.create.propertyType",
						"pattern": "",
						"type": "singleValueList",
						"url": "/pt-property/property/propertytypes/_search?&active=true|$..name|$..name",
						"isRequired": false,
						"isDisabled": false,
						"requiredErrMsg": "",
						"patternErrMsg": ""
					},
					{
						"name": "usageType",
						"jsonPath": "usageType",
						"label": "wc.create.usageType",
						"pattern": "",
						"type": "singleValueList",
						"url": "/pt-property/property/usages/_search?&active=true|$..name|$..name",
						"isRequired": false,
						"isDisabled": false,
						"requiredErrMsg": "",
						"patternErrMsg": ""
					},
						{
							"name": "Active",
							"jsonPath": "active",
							"label": "Active",
							"pattern": "",
							"type": "checkbox",
							"isRequired": false,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": ""
						}
				]
			}
		],
		"result": {
			"header": [{label: "wc.create.propertyType"},{label: "wc.create.usageType"}, {label: "wc.create.active"}],
			"values": ["propertyType","usageType", "active"],
			"resultPath": "PropertyTypeUsageTypes",
			"rowClickUrlUpdate": "/update/wc/propertyUsage/{id}",
			"rowClickUrlView": "/view/wc/propertyUsage/{id}"
			}
	},
	"wc.view": {
		"numCols": 12/3,
		"url": "/wcms/masters/propertytype-usagetype/_search?id={id}",
		"tenantIdRequired": true,
		"useTimestamp": true,
		"objectName": "PropertyTypeUsageTypes",
		"groups": [
			{
				"label": "wc.view.PropertyTypeUsageTypes.title",
				"name": "viewPropertyTypeUsageTypes",
				"fields": [
						{
							"name": "propertyType",
							"jsonPath": "PropertyTypeUsageTypes[0].propertyType",
							"label": "wc.create.propertyType",
							"pattern": "",
							"type": "text",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "usageType",
							"jsonPath": "PropertyTypeUsageTypes[0].usageType",
							"label": "wc.create.usageType",
							"pattern": "",
							"type": "text",
							"isRequired": false,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "Active",
							"jsonPath": "PropertyTypeUsageTypes[0].active",
							"label": "wc.create.active",
							"pattern": "",
							"type": "checkbox",
							"isRequired": false,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": ""
						}
				]
			}
		]
	},
	"wc.update": {
		"numCols": 12/3,
		"searchUrl": "/wcms/masters/propertytype-usagetype/_search?id={id}",
		"url":"/wcms/masters/propertytype-usagetype/_update",
		"tenantIdRequired": true,
		"useTimestamp": true,
		"objectName": "PropertyTypeUsageType",
		"groups": [
			{
				"label": "wc.update.PropertyTypeUsageType.title",
				"name": "updateDocumentTypeApplicationTypes",
				"fields": [
					{
						"name": "propertyType",
						"jsonPath": "PropertyTypeUsageType[0].propertyType",
						"label": "wc.create.propertyType",
						"pattern": "",
						"type": "singleValueList",
						"url": "/pt-property/property/propertytypes/_search?&active=true|$..name|$..name",
						"isRequired": true,
						"isDisabled": false,
						"requiredErrMsg": "",
						"patternErrMsg": ""
					},
					{
						"name": "usageType",
						"jsonPath": "PropertyTypeUsageType[0].usageType",
						"label": "wc.create.usageType",
						"pattern": "",
						"type": "singleValueList",
						"url": "/pt-property/property/usages/_search?&active=true|$..name|$..name",
						"isRequired": true,
						"isDisabled": false,
						"requiredErrMsg": "",
						"patternErrMsg": ""
					},
						{
							"name": "Active",
							"jsonPath": "PropertyTypeUsageType[0].active",
							"label": "Active",
							"pattern": "",
							"type": "checkbox",
							"isRequired": false,
							"isDisabled": false,
							"default": true,
							"requiredErrMsg": "",
							"patternErrMsg": ""
						}
				]
			}
		]
	}
}

export default dat;
