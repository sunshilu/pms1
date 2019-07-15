package com.example.pms.system.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.example.pms.system.model.UserModel;
import com.example.pms.util.FormatPOI;

@Controller
@RequestMapping("/excel")
public class ExcelController {
	
	@ResponseBody
	@RequestMapping("/export")
	private String export(HttpServletResponse response) throws Exception {
		List<UserModel> dataList=Arrays.asList(new UserModel("a1","a2","a3"),new UserModel("b1","b2","b3"));
		List<String> propList=Arrays.asList("password","roleCode","parentCode");
		List<String> fieldName=Arrays.asList("账号","姓名","密码");
		
		Workbook wb=FormatPOI.exportExcel(dataList, propList, fieldName);
		
//		1.设置响应的头文件，回自动识别文件内容
		response.setContentType("multipart/form-data");
//		2.设置Content-Disposition
		response.setHeader("Content-Disposition", "attachment;filename=test.xls");
//		3.输出流
		OutputStream out=response.getOutputStream();
		wb.write(out);
		wb.close();
		out.close();
		return null;
	}
	
	@ResponseBody
	@RequestMapping("upload")
	private String uploadExcel(CommonsMultipartResolver multipartResolver,HttpServletRequest request) throws IOException {
		Map<String,Object> result=new HashMap<>();
		result.put("code", "0");
		if(multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest) request;
			Iterator<String> iter=multiRequest.getFileNames();
			while(iter.hasNext()) {
				MultipartFile file=multiRequest.getFile(iter.next().toString());
				result.put("data", parse(file.getInputStream()));
			}
		}
		return new JSONObject(result).toString();
	}
	private List<UserModel> parse(InputStream fis) throws IOException{
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("user");
		List<UserModel> list=new ArrayList<>();
		for(Row row:sheet) {
			if(0==row.getRowNum()) {
				continue;
			}
			UserModel userModel=new UserModel();
			userModel.setCode(getValue(row.getCell(0)));
			userModel.setName(getValue(row.getCell(1)));
			userModel.setPassword(getValue(row.getCell(2)));
			list.add(userModel);
//			reg(userModel);
		}
		workbook.close();
		fis.close();
		return list;
	}
	private String getValue(Cell cell) {
		CellType type=cell.getCellTypeEnum();
		if(CellType.STRING.equals(type)) {
			return cell.getStringCellValue();
		}else if(CellType.NUMERIC.equals(type)) {
			return String.valueOf(cell.getNumericCellValue());
		}
		return null;
	}

}
