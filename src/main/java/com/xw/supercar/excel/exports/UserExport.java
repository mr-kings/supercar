package com.xw.supercar.excel.exports;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.util.StringUtils;

import com.xw.supercar.entity.Company;
import com.xw.supercar.entity.Lookup;
import com.xw.supercar.entity.User;
import com.xw.supercar.service.CompanyService;
import com.xw.supercar.service.LookupService;
import com.xw.supercar.spring.util.SpringContextHolder;

/**
 * 用户导出配置类
 *
 * @author wsz 2017-09-20
 */
public class UserExport extends IExcelExport<User>{
	/**导出到excel中的数据*/
	List<User> users = new ArrayList<>();
    /**excel的名称*/
    private String title = "用户信息.xls";
    /**excel标题行*/
    String[] headers = {"用户名", "全名", "密码", "邮箱", "手机", "角色", "公司","备注"};
    /**excel标题对应的User中的属性*/
    String[] fields = {"username", "fullname", "password", "email", "mobile", "role", "company","description"};

	@Override
	public String[] getHeader() {
		return headers;
	}

	@Override
	public int getHeaderSize() {
        return headers.length;
    }
	
	@Override
	public String[] getFields() {
		return fields;
	}

	@Override
    public String getTitle() {
        if (StringUtils.isEmpty(title)) {
        	 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            return dateFormat.format(new Date()) + "-导出记录.xls";
        } else {
            return title;
        }
    }

	@Override
	public List<User> getPoiList() {
		return this.users;
	}

	@Override
	public void setPoiList(List<User> data) {
		this.users = data;
	}
	
	@Override
	public boolean containSpecialField(String filedName) {
		if(User.DP.company.name().equals(filedName)
				|| User.DP.role.name().equals(filedName))
			return true;
		return false;
    }

	@Override
	public String getSpecialFieldValue(String filedName, Object filedValue) {
		if(User.DP.company.name().equals(filedName)) {
			String companyId = filedValue+"";
			Company company = SpringContextHolder.getBean(CompanyService.class).getById(companyId);
			if(company != null)
				return company.getName();
		}
		else if(User.DP.role.name().equals(filedName)) {
			String roleId = filedValue+"";
			Lookup role = SpringContextHolder.getBean(LookupService.class).getById(roleId);
			if(role != null) return role.getValue();
		}
        return "";
    }
}
