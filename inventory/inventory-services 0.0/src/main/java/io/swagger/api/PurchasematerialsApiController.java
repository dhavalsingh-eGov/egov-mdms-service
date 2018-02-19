package io.swagger.api;

import io.swagger.model.ErrorRes;
import io.swagger.model.PurchaseMaterialRequest;
import io.swagger.model.PurchaseMaterialResponse;
import io.swagger.model.RequestInfo;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-28T13:21:55.964+05:30")

@Controller
public class PurchasematerialsApiController implements PurchasematerialsApi {
    private final ObjectMapper objectMapper;

    public PurchasematerialsApiController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public ResponseEntity<PurchaseMaterialResponse> purchasematerialsCreatePost( @NotNull@ApiParam(value = "Unique id for a tenant.", required = true) @Valid @RequestParam(value = "tenantId", required = true) String tenantId,
        @ApiParam(value = "Create  new"  )  @Valid @RequestBody PurchaseMaterialRequest purchaseMaterialRequest,
        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
        // do some magic!

        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<PurchaseMaterialResponse>(objectMapper.readValue("{  \"purchaseMaterials\" : [ {    \"uom\" : {      \"code\" : \"code\",      \"auditDetails\" : {        \"lastModifiedTime\" : 1,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 6      },      \"tenantId\" : \"tenantId\",      \"name\" : \"name\",      \"id\" : \"id\"    },    \"material\" : {      \"code\" : \"code\",      \"maxQuantity\" : 7.061401241503109105224211816675961017608642578125,      \"description\" : \"description\",      \"reorderQuantity\" : 3.61607674925191080461672754609026014804840087890625,      \"reorderLevel\" : 9.301444243932575517419536481611430644989013671875,      \"techincalSpecs\" : \"techincalSpecs\",      \"termsOfDelivery\" : \"termsOfDelivery\",      \"minQuantity\" : 2.3021358869347654518833223846741020679473876953125,      \"auditDetails\" : {        \"lastModifiedTime\" : 1,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 6      },      \"materialControlType\" : \"LOTControl\",      \"manufacturePartNo\" : \"manufacturePartNo\",      \"model\" : \"model\",      \"id\" : \"id\",      \"staockingUom\" : {        \"code\" : \"code\",        \"auditDetails\" : {          \"lastModifiedTime\" : 1,          \"createdBy\" : \"createdBy\",          \"lastModifiedBy\" : \"lastModifiedBy\",          \"createdTime\" : 6        },        \"tenantId\" : \"tenantId\",        \"name\" : \"name\",        \"id\" : \"id\"      },      \"inventoryType\" : \"Asset\",      \"materialClass\" : \"HighUsage\",      \"materialType\" : {        \"parent\" : 5,        \"code\" : \"code\",        \"auditDetails\" : {          \"lastModifiedTime\" : 1,          \"createdBy\" : \"createdBy\",          \"lastModifiedBy\" : \"lastModifiedBy\",          \"createdTime\" : 6        },        \"tenantId\" : \"tenantId\",        \"name\" : \"name\",        \"id\" : \"id\"      },      \"purchaseUom\" : {        \"code\" : \"code\",        \"auditDetails\" : {          \"lastModifiedTime\" : 1,          \"createdBy\" : \"createdBy\",          \"lastModifiedBy\" : \"lastModifiedBy\",          \"createdTime\" : 6        },        \"tenantId\" : \"tenantId\",        \"name\" : \"name\",        \"id\" : \"id\"      },      \"baseUom\" : {        \"code\" : \"code\",        \"auditDetails\" : {          \"lastModifiedTime\" : 1,          \"createdBy\" : \"createdBy\",          \"lastModifiedBy\" : \"lastModifiedBy\",          \"createdTime\" : 6        },        \"tenantId\" : \"tenantId\",        \"name\" : \"name\",        \"id\" : \"id\"      },      \"oldCode\" : \"oldCode\",      \"tenantId\" : \"tenantId\",      \"name\" : \"name\",      \"expenseAccount\" : {        \"glCode\" : \"glCode\",        \"auditDetails\" : {          \"lastModifiedTime\" : 1,          \"createdBy\" : \"createdBy\",          \"lastModifiedBy\" : \"lastModifiedBy\",          \"createdTime\" : 6        },        \"tenantId\" : \"tenantId\",        \"name\" : \"name\",        \"id\" : \"id\"      },      \"overrideMaterialControlType\" : true,      \"status\" : \"Active\"    },    \"auditDetails\" : {      \"lastModifiedTime\" : 1,      \"createdBy\" : \"createdBy\",      \"lastModifiedBy\" : \"lastModifiedBy\",      \"createdTime\" : 6    },    \"tenantId\" : \"tenantId\",    \"description\" : \"description\",    \"id\" : \"id\",    \"orderQuantity\" : 2.3021358869347654518833223846741020679473876953125  }, {    \"uom\" : {      \"code\" : \"code\",      \"auditDetails\" : {        \"lastModifiedTime\" : 1,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 6      },      \"tenantId\" : \"tenantId\",      \"name\" : \"name\",      \"id\" : \"id\"    },    \"material\" : {      \"code\" : \"code\",      \"maxQuantity\" : 7.061401241503109105224211816675961017608642578125,      \"description\" : \"description\",      \"reorderQuantity\" : 3.61607674925191080461672754609026014804840087890625,      \"reorderLevel\" : 9.301444243932575517419536481611430644989013671875,      \"techincalSpecs\" : \"techincalSpecs\",      \"termsOfDelivery\" : \"termsOfDelivery\",      \"minQuantity\" : 2.3021358869347654518833223846741020679473876953125,      \"auditDetails\" : {        \"lastModifiedTime\" : 1,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 6      },      \"materialControlType\" : \"LOTControl\",      \"manufacturePartNo\" : \"manufacturePartNo\",      \"model\" : \"model\",      \"id\" : \"id\",      \"staockingUom\" : {        \"code\" : \"code\",        \"auditDetails\" : {          \"lastModifiedTime\" : 1,          \"createdBy\" : \"createdBy\",          \"lastModifiedBy\" : \"lastModifiedBy\",          \"createdTime\" : 6        },        \"tenantId\" : \"tenantId\",        \"name\" : \"name\",        \"id\" : \"id\"      },      \"inventoryType\" : \"Asset\",      \"materialClass\" : \"HighUsage\",      \"materialType\" : {        \"parent\" : 5,        \"code\" : \"code\",        \"auditDetails\" : {          \"lastModifiedTime\" : 1,          \"createdBy\" : \"createdBy\",          \"lastModifiedBy\" : \"lastModifiedBy\",          \"createdTime\" : 6        },        \"tenantId\" : \"tenantId\",        \"name\" : \"name\",        \"id\" : \"id\"      },      \"purchaseUom\" : {        \"code\" : \"code\",        \"auditDetails\" : {          \"lastModifiedTime\" : 1,          \"createdBy\" : \"createdBy\",          \"lastModifiedBy\" : \"lastModifiedBy\",          \"createdTime\" : 6        },        \"tenantId\" : \"tenantId\",        \"name\" : \"name\",        \"id\" : \"id\"      },      \"baseUom\" : {        \"code\" : \"code\",        \"auditDetails\" : {          \"lastModifiedTime\" : 1,          \"createdBy\" : \"createdBy\",          \"lastModifiedBy\" : \"lastModifiedBy\",          \"createdTime\" : 6        },        \"tenantId\" : \"tenantId\",        \"name\" : \"name\",        \"id\" : \"id\"      },      \"oldCode\" : \"oldCode\",      \"tenantId\" : \"tenantId\",      \"name\" : \"name\",      \"expenseAccount\" : {        \"glCode\" : \"glCode\",        \"auditDetails\" : {          \"lastModifiedTime\" : 1,          \"createdBy\" : \"createdBy\",          \"lastModifiedBy\" : \"lastModifiedBy\",          \"createdTime\" : 6        },        \"tenantId\" : \"tenantId\",        \"name\" : \"name\",        \"id\" : \"id\"      },      \"overrideMaterialControlType\" : true,      \"status\" : \"Active\"    },    \"auditDetails\" : {      \"lastModifiedTime\" : 1,      \"createdBy\" : \"createdBy\",      \"lastModifiedBy\" : \"lastModifiedBy\",      \"createdTime\" : 6    },    \"tenantId\" : \"tenantId\",    \"description\" : \"description\",    \"id\" : \"id\",    \"orderQuantity\" : 2.3021358869347654518833223846741020679473876953125  } ],  \"page\" : {    \"totalResults\" : 1,    \"offSet\" : 1,    \"totalPages\" : 1,    \"pageSize\" : 6,    \"currentPage\" : 7  },  \"responseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  }}", PurchaseMaterialResponse.class), HttpStatus.OK);
        }

        return new ResponseEntity<PurchaseMaterialResponse>(HttpStatus.OK);
    }

    public ResponseEntity<PurchaseMaterialResponse> purchasematerialsSearchPost( @NotNull@ApiParam(value = "Unique id for a tenant.", required = true) @Valid @RequestParam(value = "tenantId", required = true) String tenantId,
        @ApiParam(value = "Parameter to carry Request metadata in the request body"  )  @Valid @RequestBody RequestInfo requestInfo,
         @Size(max=50)@ApiParam(value = "comma seperated list of Ids") @Valid @RequestParam(value = "ids", required = false) List<String> ids,
        @ApiParam(value = "material of the PurchaseMaterial ") @Valid @RequestParam(value = "material", required = false) Long material,
        @ApiParam(value = "uom of the PurchaseMaterial ") @Valid @RequestParam(value = "uom", required = false) Long uom,
        @ApiParam(value = "order quantity of the PurchaseMaterial ") @Valid @RequestParam(value = "orderQuantity", required = false) Integer orderQuantity,
        @ApiParam(value = "remarks of the PurchaseMaterial ") @Valid @RequestParam(value = "remarks", required = false) String remarks,
        @ApiParam(value = "pageSize") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
        @ApiParam(value = "offset") @Valid @RequestParam(value = "offset", required = false) Integer offset,
        @ApiParam(value = "This takes any field from the Object seperated by comma and asc,desc keywords.   example name asc,code desc or name,code or name,code desc  ") @Valid @RequestParam(value = "sortBy", required = false) String sortBy,
        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
        // do some magic!

        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<PurchaseMaterialResponse>(objectMapper.readValue("{  \"purchaseMaterials\" : [ {    \"uom\" : {      \"code\" : \"code\",      \"auditDetails\" : {        \"lastModifiedTime\" : 1,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 6      },      \"tenantId\" : \"tenantId\",      \"name\" : \"name\",      \"id\" : \"id\"    },    \"material\" : {      \"code\" : \"code\",      \"maxQuantity\" : 7.061401241503109105224211816675961017608642578125,      \"description\" : \"description\",      \"reorderQuantity\" : 3.61607674925191080461672754609026014804840087890625,      \"reorderLevel\" : 9.301444243932575517419536481611430644989013671875,      \"techincalSpecs\" : \"techincalSpecs\",      \"termsOfDelivery\" : \"termsOfDelivery\",      \"minQuantity\" : 2.3021358869347654518833223846741020679473876953125,      \"auditDetails\" : {        \"lastModifiedTime\" : 1,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 6      },      \"materialControlType\" : \"LOTControl\",      \"manufacturePartNo\" : \"manufacturePartNo\",      \"model\" : \"model\",      \"id\" : \"id\",      \"staockingUom\" : {        \"code\" : \"code\",        \"auditDetails\" : {          \"lastModifiedTime\" : 1,          \"createdBy\" : \"createdBy\",          \"lastModifiedBy\" : \"lastModifiedBy\",          \"createdTime\" : 6        },        \"tenantId\" : \"tenantId\",        \"name\" : \"name\",        \"id\" : \"id\"      },      \"inventoryType\" : \"Asset\",      \"materialClass\" : \"HighUsage\",      \"materialType\" : {        \"parent\" : 5,        \"code\" : \"code\",        \"auditDetails\" : {          \"lastModifiedTime\" : 1,          \"createdBy\" : \"createdBy\",          \"lastModifiedBy\" : \"lastModifiedBy\",          \"createdTime\" : 6        },        \"tenantId\" : \"tenantId\",        \"name\" : \"name\",        \"id\" : \"id\"      },      \"purchaseUom\" : {        \"code\" : \"code\",        \"auditDetails\" : {          \"lastModifiedTime\" : 1,          \"createdBy\" : \"createdBy\",          \"lastModifiedBy\" : \"lastModifiedBy\",          \"createdTime\" : 6        },        \"tenantId\" : \"tenantId\",        \"name\" : \"name\",        \"id\" : \"id\"      },      \"baseUom\" : {        \"code\" : \"code\",        \"auditDetails\" : {          \"lastModifiedTime\" : 1,          \"createdBy\" : \"createdBy\",          \"lastModifiedBy\" : \"lastModifiedBy\",          \"createdTime\" : 6        },        \"tenantId\" : \"tenantId\",        \"name\" : \"name\",        \"id\" : \"id\"      },      \"oldCode\" : \"oldCode\",      \"tenantId\" : \"tenantId\",      \"name\" : \"name\",      \"expenseAccount\" : {        \"glCode\" : \"glCode\",        \"auditDetails\" : {          \"lastModifiedTime\" : 1,          \"createdBy\" : \"createdBy\",          \"lastModifiedBy\" : \"lastModifiedBy\",          \"createdTime\" : 6        },        \"tenantId\" : \"tenantId\",        \"name\" : \"name\",        \"id\" : \"id\"      },      \"overrideMaterialControlType\" : true,      \"status\" : \"Active\"    },    \"auditDetails\" : {      \"lastModifiedTime\" : 1,      \"createdBy\" : \"createdBy\",      \"lastModifiedBy\" : \"lastModifiedBy\",      \"createdTime\" : 6    },    \"tenantId\" : \"tenantId\",    \"description\" : \"description\",    \"id\" : \"id\",    \"orderQuantity\" : 2.3021358869347654518833223846741020679473876953125  }, {    \"uom\" : {      \"code\" : \"code\",      \"auditDetails\" : {        \"lastModifiedTime\" : 1,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 6      },      \"tenantId\" : \"tenantId\",      \"name\" : \"name\",      \"id\" : \"id\"    },    \"material\" : {      \"code\" : \"code\",      \"maxQuantity\" : 7.061401241503109105224211816675961017608642578125,      \"description\" : \"description\",      \"reorderQuantity\" : 3.61607674925191080461672754609026014804840087890625,      \"reorderLevel\" : 9.301444243932575517419536481611430644989013671875,      \"techincalSpecs\" : \"techincalSpecs\",      \"termsOfDelivery\" : \"termsOfDelivery\",      \"minQuantity\" : 2.3021358869347654518833223846741020679473876953125,      \"auditDetails\" : {        \"lastModifiedTime\" : 1,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 6      },      \"materialControlType\" : \"LOTControl\",      \"manufacturePartNo\" : \"manufacturePartNo\",      \"model\" : \"model\",      \"id\" : \"id\",      \"staockingUom\" : {        \"code\" : \"code\",        \"auditDetails\" : {          \"lastModifiedTime\" : 1,          \"createdBy\" : \"createdBy\",          \"lastModifiedBy\" : \"lastModifiedBy\",          \"createdTime\" : 6        },        \"tenantId\" : \"tenantId\",        \"name\" : \"name\",        \"id\" : \"id\"      },      \"inventoryType\" : \"Asset\",      \"materialClass\" : \"HighUsage\",      \"materialType\" : {        \"parent\" : 5,        \"code\" : \"code\",        \"auditDetails\" : {          \"lastModifiedTime\" : 1,          \"createdBy\" : \"createdBy\",          \"lastModifiedBy\" : \"lastModifiedBy\",          \"createdTime\" : 6        },        \"tenantId\" : \"tenantId\",        \"name\" : \"name\",        \"id\" : \"id\"      },      \"purchaseUom\" : {        \"code\" : \"code\",        \"auditDetails\" : {          \"lastModifiedTime\" : 1,          \"createdBy\" : \"createdBy\",          \"lastModifiedBy\" : \"lastModifiedBy\",          \"createdTime\" : 6        },        \"tenantId\" : \"tenantId\",        \"name\" : \"name\",        \"id\" : \"id\"      },      \"baseUom\" : {        \"code\" : \"code\",        \"auditDetails\" : {          \"lastModifiedTime\" : 1,          \"createdBy\" : \"createdBy\",          \"lastModifiedBy\" : \"lastModifiedBy\",          \"createdTime\" : 6        },        \"tenantId\" : \"tenantId\",        \"name\" : \"name\",        \"id\" : \"id\"      },      \"oldCode\" : \"oldCode\",      \"tenantId\" : \"tenantId\",      \"name\" : \"name\",      \"expenseAccount\" : {        \"glCode\" : \"glCode\",        \"auditDetails\" : {          \"lastModifiedTime\" : 1,          \"createdBy\" : \"createdBy\",          \"lastModifiedBy\" : \"lastModifiedBy\",          \"createdTime\" : 6        },        \"tenantId\" : \"tenantId\",        \"name\" : \"name\",        \"id\" : \"id\"      },      \"overrideMaterialControlType\" : true,      \"status\" : \"Active\"    },    \"auditDetails\" : {      \"lastModifiedTime\" : 1,      \"createdBy\" : \"createdBy\",      \"lastModifiedBy\" : \"lastModifiedBy\",      \"createdTime\" : 6    },    \"tenantId\" : \"tenantId\",    \"description\" : \"description\",    \"id\" : \"id\",    \"orderQuantity\" : 2.3021358869347654518833223846741020679473876953125  } ],  \"page\" : {    \"totalResults\" : 1,    \"offSet\" : 1,    \"totalPages\" : 1,    \"pageSize\" : 6,    \"currentPage\" : 7  },  \"responseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  }}", PurchaseMaterialResponse.class), HttpStatus.OK);
        }

        return new ResponseEntity<PurchaseMaterialResponse>(HttpStatus.OK);
    }

    public ResponseEntity<PurchaseMaterialResponse> purchasematerialsUpdatePost( @NotNull@ApiParam(value = "Unique id for a tenant.", required = true) @Valid @RequestParam(value = "tenantId", required = true) String tenantId,
        @ApiParam(value = "common Request info"  )  @Valid @RequestBody PurchaseMaterialRequest purchaseMaterialRequest,
        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
        // do some magic!

        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<PurchaseMaterialResponse>(objectMapper.readValue("{  \"purchaseMaterials\" : [ {    \"uom\" : {      \"code\" : \"code\",      \"auditDetails\" : {        \"lastModifiedTime\" : 1,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 6      },      \"tenantId\" : \"tenantId\",      \"name\" : \"name\",      \"id\" : \"id\"    },    \"material\" : {      \"code\" : \"code\",      \"maxQuantity\" : 7.061401241503109105224211816675961017608642578125,      \"description\" : \"description\",      \"reorderQuantity\" : 3.61607674925191080461672754609026014804840087890625,      \"reorderLevel\" : 9.301444243932575517419536481611430644989013671875,      \"techincalSpecs\" : \"techincalSpecs\",      \"termsOfDelivery\" : \"termsOfDelivery\",      \"minQuantity\" : 2.3021358869347654518833223846741020679473876953125,      \"auditDetails\" : {        \"lastModifiedTime\" : 1,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 6      },      \"materialControlType\" : \"LOTControl\",      \"manufacturePartNo\" : \"manufacturePartNo\",      \"model\" : \"model\",      \"id\" : \"id\",      \"staockingUom\" : {        \"code\" : \"code\",        \"auditDetails\" : {          \"lastModifiedTime\" : 1,          \"createdBy\" : \"createdBy\",          \"lastModifiedBy\" : \"lastModifiedBy\",          \"createdTime\" : 6        },        \"tenantId\" : \"tenantId\",        \"name\" : \"name\",        \"id\" : \"id\"      },      \"inventoryType\" : \"Asset\",      \"materialClass\" : \"HighUsage\",      \"materialType\" : {        \"parent\" : 5,        \"code\" : \"code\",        \"auditDetails\" : {          \"lastModifiedTime\" : 1,          \"createdBy\" : \"createdBy\",          \"lastModifiedBy\" : \"lastModifiedBy\",          \"createdTime\" : 6        },        \"tenantId\" : \"tenantId\",        \"name\" : \"name\",        \"id\" : \"id\"      },      \"purchaseUom\" : {        \"code\" : \"code\",        \"auditDetails\" : {          \"lastModifiedTime\" : 1,          \"createdBy\" : \"createdBy\",          \"lastModifiedBy\" : \"lastModifiedBy\",          \"createdTime\" : 6        },        \"tenantId\" : \"tenantId\",        \"name\" : \"name\",        \"id\" : \"id\"      },      \"baseUom\" : {        \"code\" : \"code\",        \"auditDetails\" : {          \"lastModifiedTime\" : 1,          \"createdBy\" : \"createdBy\",          \"lastModifiedBy\" : \"lastModifiedBy\",          \"createdTime\" : 6        },        \"tenantId\" : \"tenantId\",        \"name\" : \"name\",        \"id\" : \"id\"      },      \"oldCode\" : \"oldCode\",      \"tenantId\" : \"tenantId\",      \"name\" : \"name\",      \"expenseAccount\" : {        \"glCode\" : \"glCode\",        \"auditDetails\" : {          \"lastModifiedTime\" : 1,          \"createdBy\" : \"createdBy\",          \"lastModifiedBy\" : \"lastModifiedBy\",          \"createdTime\" : 6        },        \"tenantId\" : \"tenantId\",        \"name\" : \"name\",        \"id\" : \"id\"      },      \"overrideMaterialControlType\" : true,      \"status\" : \"Active\"    },    \"auditDetails\" : {      \"lastModifiedTime\" : 1,      \"createdBy\" : \"createdBy\",      \"lastModifiedBy\" : \"lastModifiedBy\",      \"createdTime\" : 6    },    \"tenantId\" : \"tenantId\",    \"description\" : \"description\",    \"id\" : \"id\",    \"orderQuantity\" : 2.3021358869347654518833223846741020679473876953125  }, {    \"uom\" : {      \"code\" : \"code\",      \"auditDetails\" : {        \"lastModifiedTime\" : 1,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 6      },      \"tenantId\" : \"tenantId\",      \"name\" : \"name\",      \"id\" : \"id\"    },    \"material\" : {      \"code\" : \"code\",      \"maxQuantity\" : 7.061401241503109105224211816675961017608642578125,      \"description\" : \"description\",      \"reorderQuantity\" : 3.61607674925191080461672754609026014804840087890625,      \"reorderLevel\" : 9.301444243932575517419536481611430644989013671875,      \"techincalSpecs\" : \"techincalSpecs\",      \"termsOfDelivery\" : \"termsOfDelivery\",      \"minQuantity\" : 2.3021358869347654518833223846741020679473876953125,      \"auditDetails\" : {        \"lastModifiedTime\" : 1,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 6      },      \"materialControlType\" : \"LOTControl\",      \"manufacturePartNo\" : \"manufacturePartNo\",      \"model\" : \"model\",      \"id\" : \"id\",      \"staockingUom\" : {        \"code\" : \"code\",        \"auditDetails\" : {          \"lastModifiedTime\" : 1,          \"createdBy\" : \"createdBy\",          \"lastModifiedBy\" : \"lastModifiedBy\",          \"createdTime\" : 6        },        \"tenantId\" : \"tenantId\",        \"name\" : \"name\",        \"id\" : \"id\"      },      \"inventoryType\" : \"Asset\",      \"materialClass\" : \"HighUsage\",      \"materialType\" : {        \"parent\" : 5,        \"code\" : \"code\",        \"auditDetails\" : {          \"lastModifiedTime\" : 1,          \"createdBy\" : \"createdBy\",          \"lastModifiedBy\" : \"lastModifiedBy\",          \"createdTime\" : 6        },        \"tenantId\" : \"tenantId\",        \"name\" : \"name\",        \"id\" : \"id\"      },      \"purchaseUom\" : {        \"code\" : \"code\",        \"auditDetails\" : {          \"lastModifiedTime\" : 1,          \"createdBy\" : \"createdBy\",          \"lastModifiedBy\" : \"lastModifiedBy\",          \"createdTime\" : 6        },        \"tenantId\" : \"tenantId\",        \"name\" : \"name\",        \"id\" : \"id\"      },      \"baseUom\" : {        \"code\" : \"code\",        \"auditDetails\" : {          \"lastModifiedTime\" : 1,          \"createdBy\" : \"createdBy\",          \"lastModifiedBy\" : \"lastModifiedBy\",          \"createdTime\" : 6        },        \"tenantId\" : \"tenantId\",        \"name\" : \"name\",        \"id\" : \"id\"      },      \"oldCode\" : \"oldCode\",      \"tenantId\" : \"tenantId\",      \"name\" : \"name\",      \"expenseAccount\" : {        \"glCode\" : \"glCode\",        \"auditDetails\" : {          \"lastModifiedTime\" : 1,          \"createdBy\" : \"createdBy\",          \"lastModifiedBy\" : \"lastModifiedBy\",          \"createdTime\" : 6        },        \"tenantId\" : \"tenantId\",        \"name\" : \"name\",        \"id\" : \"id\"      },      \"overrideMaterialControlType\" : true,      \"status\" : \"Active\"    },    \"auditDetails\" : {      \"lastModifiedTime\" : 1,      \"createdBy\" : \"createdBy\",      \"lastModifiedBy\" : \"lastModifiedBy\",      \"createdTime\" : 6    },    \"tenantId\" : \"tenantId\",    \"description\" : \"description\",    \"id\" : \"id\",    \"orderQuantity\" : 2.3021358869347654518833223846741020679473876953125  } ],  \"page\" : {    \"totalResults\" : 1,    \"offSet\" : 1,    \"totalPages\" : 1,    \"pageSize\" : 6,    \"currentPage\" : 7  },  \"responseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  }}", PurchaseMaterialResponse.class), HttpStatus.OK);
        }

        return new ResponseEntity<PurchaseMaterialResponse>(HttpStatus.OK);
    }

}