package org.egov.wcms.transaction.web.contract;

import java.util.List;

import org.egov.common.contract.response.ResponseInfo;
import org.egov.wcms.transaction.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserResponseInfo {
	
	private List<User> users;
	
	private ResponseInfo responseInfo;

}
