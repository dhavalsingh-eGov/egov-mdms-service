delete from egcl_bankaccountservicemapping;

insert into egcl_bankaccountservicemapping(id,businessdetails,bankaccount,bank,bankbranch,active,createdby,lastmodifiedby,tenantid,version)
values(nextval('seq_egcl_bankaccountservicemapping'),'ATH','000000000001','SBI','BC001',true,1,1,'pb.jalandhar',0);