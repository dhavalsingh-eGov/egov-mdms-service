var dat = {
  "legal.search": {
    numCols: 4,
    title:"opinion.search.document.title",
    useTimestamp: true,
    objectName: "",
    url: "/lcms-services/legalcase/opinion/_search",
   groups: [
      {
        name: "search",
        label: " ",
        fields: [
          {
            name: "opinionFromDate",
            jsonPath: "fromDate",
            label: "opinion.create.opinionFromDate",
            type: "datePicker",
            isRequired: false,
            isDisabled: false,
            patternErrorMsg: "opinion.create.field.message.opinionRequestDate"
          },
          {
            name: "opinionToDate",
            jsonPath: "toDate",
            label: "opinion.create.opinionToDate",
            type: "datePicker",
            isRequired: false,
            isDisabled: false,
            patternErrorMsg: "opinion.create.field.message.opinionRequestDate"
          },
          {
            name: "ids",
            jsonPath: "ids",
            label: "opinion.createids",
            type: "",
            isDisabled: false,
            patternErrorMsg: "opinion.create.field.message.ids"
          },
          {
            name: "departMentName",
            jsonPath: "departmentName",
            label: "opinion.createdepartMentName",
            type: "singleValueList",
            isRequired: false,
            isDisabled: false,
            patternErrorMsg: "opinion.create.field.message.departMentName",
            url: "/egov-common-masters/departments/_search?|$..code|$..name"
          },
          {
            name: "opinionBy",
            jsonPath: "opinionBy",
            label: "opinion.createopinionBy",
            type: "text",
            isRequired: false,
            isDisabled: false,
            patternErrorMsg: "opinion.create.field.message.opinionBy"
          }
          
        ]
      }
    ],
    result: {
      "disableRowClick" : true,
       isAction: true,
      actionItems: [
            {
              label: "Opinion Assign Advocate",
             url:"/update/legal/opinionassignadvocate/"
            },
            {
              label: "Update Opinion",
              url: "/update/legal/updateopinion/"
            },
            // {
            //   label: "Update",
            //   url: "/update/legal/opiniondetails/"
            // },
             {
              label: "View",
              url: "/view/legal/opiniondetails/"
            }
          ],
      header: [
         {
          label: "legal.search.result.actionLabels",
          isChecked:true,
          checkedItem:{
            jsonPath:"checkedRow",
            label:"",
          }
        },
        { label: "opinion.search.result.id" },
        { label: "opinion.search.result.departmentName" },
        { label: "opinion.search.result.opinionOn" }
      ],
      values: ["code","code", "departmentName.name", "opinionOn"],
      resultPath: "opinions",
      rowClickUrlUpdate: "/update/opinion/{id}",
      rowClickUrlView: "/view/opinion/{id}"
    }
  },
  "legal.create": {
    numCols: 4,
    title:"opinion.create.document.title",
    title:"opinion.create.document.title",
    useTimestamp: true,
    objectName: "opinions",
    groups: [
      {
        name: "OpinionRequest",
        label: "opinion.create.group.title.OpinionRequest",
        fields: [
          {
            name: "opinionRequestDate",
            jsonPath: "opinions[0].opinionRequestDate",
            label: "opinion.create.opinionRequestDate",
            type: "datePicker",
            isRequired: true,
            isDisabled: false,
            patternErrorMsg: ""
          },
          {
            name: "departmentName",
            jsonPath: "opinions[0].departmentName.code",
            label: "opinion.create.departmentName",
            type: "singleValueList",
            isRequired: true,
            isDisabled: false,
            patternErrorMsg: "",
            url: "/egov-common-masters/departments/_search?|$..code|$..name"
          },{
            name: "Case",
            jsonPath: "opinions[0].caseDetails.summonReferenceNo",
            label: "opinion.create.case",
            type: "singleValueList",
            isRequired: false,
            isDisabled: false,
            patternErrorMsg: "",
            url: "/lcms-services/legalcase/caseno/_search?|$..summonReferenceNo|$..caseNo"
          },
          {
            name: "opinionOn",
            jsonPath: "opinions[0].opinionOn",
            label: "opinion.create.opinionOn",
            type: "textarea",
            fullWidth:true,
            isRequired: true,
            isDisabled: false,
            patternErrorMsg: ""
          }
        ]
      },{
        "name": "UploadDocument",
        "label": "legal.create.group.title.UploadDocument",
        fields:[ {
          "name": "UploadDocument",
          "jsonPath": "opinions[0].documents",
          "label": "legal.create.sectionApplied",
          "type": "fileTable",
          "isRequired": false,
          "isDisabled": false,
          "patternErrMsg": "",
          "fileList": {
            "name": "documentName",
            "id": "fileStoreId"
          },
          "fileCount": 3
        }]
      }
    ],
    url: "/lcms-services/legalcase/opinion/_create",
    tenantIdRequired: true
  },
  "legal.view": {
    numCols: 4,
    title:"opinion.view.document.title",
    useTimestamp: true,
    objectName: "opinions",
    groups: [
      {
        name: "OpinionRequest",
        label: "opinion.create.group.title.OpinionRequest",
        fields: [
          {
            name: "opinionRequestDate",
            jsonPath: "opinions[0].opinionRequestDate",
            label: "opinion.create.opinionRequestDate",
            type: "number",
            isRequired: false,
            isDisabled: false,
            patternErrorMsg: ""
          },
          {
            name: "departmentName",
            jsonPath: "opinions[0].departmentName",
            label: "opinion.create.departmentName",
            type: "singleValueList",
            isRequired: true,
            isDisabled: false,
            patternErrorMsg: "",
            url: "/egov-common-masters/departments/_search?|$..code|$..name"
          },
          {
            name: "opinionOn",
            jsonPath: "opinions[0].opinionOn",
            label: "opinion.create.opinionOn",
            type: "text",
            isRequired: true,
            isDisabled: false,
            patternErrorMsg: ""
          }
        ]
      }
    ],
    tenantIdRequired: true
  },
  "legal.update": {
    numCols: 4,
    title:"opinion.update.document.title",
    useTimestamp: true,
    objectName: "opinions",
    groups: [
      {
        name: "OpinionRequest",
        label: "opinion.create.group.title.OpinionRequest",
        fields: [
          {
            name: "opinionRequestDate",
            jsonPath: "opinions[0].opinionRequestDate",
            label: "opinion.create.opinionRequestDate",
            type: "number",
            isRequired: true,
            isDisabled: false,
            patternErrorMsg: ""
          },
          {
            name: "departmentName",
            jsonPath: "opinions[0].departmentName",
            label: "opinion.create.departmentName",
            type: "singleValueList",
            isRequired: true,
            isDisabled: false,
            patternErrorMsg: "",
            url: "/egov-common-masters/departments/_search?|$..code|$..name"
          },
          {
            name: "opinionOn",
            jsonPath: "opinions[0].opinionOn",
            label: "opinion.create.opinionOn",
            type: "text",
            isRequired: true,
            isDisabled: false,
            patternErrorMsg: ""
          }
        ]
      }
    ],
    url: "//opinion/_update",
    tenantIdRequired: true
  }
};
export default dat;
