
var dat = {
	"addDemand.create": {
		"numCols": 12/4,
		"version": "v1",
		"url": "",
		"useTimestamp": true,
		"objectName": "properties",
		"level": 0,
		"groups": [
			
			{
				"label": "Add DCB",
				"name": "AddDcb",
				"jsonPath": "",
				"multiple":true,
				"fields": [
						{
							"name": "Installment",
							"jsonPath": "installment",
							"label": "pt.create.groups.addDemand.fields.installment",
							"pattern": "",
							"type": "text",
							"isRequired": true,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": "",
							"defaultValue": []
						},
						{
							"name": "Propertytax",
							"jsonPath": "Propertytax",
							"label": "pt.create.groups.addDemand.fields.propertytax",
							"pattern": "",
							"type": "number",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						},
						{
							"name": "EducationCess",
							"jsonPath": "EducationCess",
							"label": "pt.create.groups.addDemand.fields.educationCess",
							"pattern": "",
							"type": "number",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						},
						{
							"name": "EmploymentGuaranteeCess",
							"jsonPath": "EmploymentGuaranteeCess",
							"label": "pt.create.groups.addDemand.fields.employmentGuaranteeCess",
							"pattern": "",
							"type": "number",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						},
						{
							"name": "Treetax",
							"jsonPath": "Treetax",
							"label": "pt.create.groups.addDemand.fields.treetax",
							"pattern": "",
							"type": "number",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						},
						{
							"name": "TotalPropertyTax",
							"jsonPath": "TotalPropertyTax",
							"label": "pt.create.groups.addDemand.fields.totalPropertyTax",
							"pattern": "",
							"type": "number",
							"isRequired": false,
							"isDisabled": true,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						},
						{
							"name": "Collection",
							"jsonPath": "Collection",
							"label": "pt.create.groups.addDemand.fields.collection",
							"pattern": "",
							"type": "number",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						},
				]
			},
			
		]
	},
	
	"addDemand.update": {
		"numCols": 12/4,
		"version": "v1",
		"searchUrl": "/wcms/masters/pipesize/_search?id={id}",
		"url": "pt-property/properties/_update",
		"useTimestamp": true,
		"objectName": "properties",
		"level": 0,
		"groups": [
			
			{
				"label": "Owner Details",
				"name": "OwnerDetails",
				"jsonPath": "properties[0].owners",
				"multiple":true,
				"fields": [
						{
							"name": "Installment",
							"jsonPath": "installment",
							"label": "pt.create.groups.addDemand.fields.installment",
							"pattern": "",
							"type": "text",
							"isRequired": true,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": "",
							"defaultValue": []
						},
						{
							"name": "Propertytax",
							"jsonPath": "Propertytax",
							"label": "pt.create.groups.addDemand.fields.propertytax",
							"pattern": "",
							"type": "number",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						},
						{
							"name": "EducationCess",
							"jsonPath": "EducationCess",
							"label": "pt.create.groups.addDemand.fields.educationCess",
							"pattern": "",
							"type": "number",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						},
						{
							"name": "EmploymentGuaranteeCess",
							"jsonPath": "EmploymentGuaranteeCess",
							"label": "pt.create.groups.addDemand.fields.employmentGuaranteeCess",
							"pattern": "",
							"type": "number",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						},
						{
							"name": "Treetax",
							"jsonPath": "Treetax",
							"label": "pt.create.groups.addDemand.fields.treetax",
							"pattern": "",
							"type": "number",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						},
						{
							"name": "TotalPropertyTax",
							"jsonPath": "TotalPropertyTax",
							"label": "pt.create.groups.addDemand.fields.totalPropertyTax",
							"pattern": "",
							"type": "number",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						},
						{
							"name": "Collection",
							"jsonPath": "Collection",
							"label": "pt.create.groups.addDemand.fields.collection",
							"pattern": "",
							"type": "number",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						},
						
				]
			},
			
		]
	},
	
	
	
	
}

export default dat;