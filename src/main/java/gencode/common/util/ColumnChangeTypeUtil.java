package gencode.common.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Administrator
 * 根据java类型，获取列类型
 */
public class ColumnChangeTypeUtil {

	/**
	 * @param dbtype
	 * @param xsd
	 * @return
	 * 得到对应的java类型
	 */
	public static String getJavaType(String dbtype,int xsd){
		if(StringUtils.containsIgnoreCase(dbtype, "int")
				|| StringUtils.containsIgnoreCase(dbtype, "number")
				){
			if(xsd>0){
				return "Double";
			}else{
				return "Long";
			}
		}else if(StringUtils.containsIgnoreCase(dbtype, "float")
				|| StringUtils.containsIgnoreCase(dbtype, "double")
				|| StringUtils.containsIgnoreCase(dbtype, "decimal")
				){
			if(xsd>0){
				return "Double";
			}else{
				return "Long";
			}
		}else if(StringUtils.containsIgnoreCase(dbtype, "varchar")
				||StringUtils.containsIgnoreCase(dbtype, "char")
				||StringUtils.containsIgnoreCase(dbtype, "text")
				||StringUtils.containsIgnoreCase(dbtype, "clob")
				){
			return "String";
			
		}else if(StringUtils.containsIgnoreCase(dbtype, "date")
				|| StringUtils.containsIgnoreCase(dbtype, "datetime")
				||StringUtils.containsIgnoreCase(dbtype, "timestamp")
			){
			return "java.util.Date";
		}else {
			return "";
		}
	}
	
	/**
	 * @param ctitle
	 * @return
	 * 得到生成的java列名
	 */
	public static String getJavaName(String ctitle){
		String temp = "";
		String[] cns = StringUtils.split(ctitle, "_");
		boolean fg = false;
		for(int a = 0;a<cns.length;a++){
			String c = cns[a];
			if(a==0){
				if(c.length()==1){
					fg = true;
					temp = temp+c.toLowerCase();
				}else{
					temp = temp+CharUpperLowerUtil.toLowerCaseFirstOne(c);
				}
			}else{
				if(fg && a==1){
					temp = temp+CharUpperLowerUtil.toLowerCaseFirstOne(c);
				}else{
					temp =temp + CharUpperLowerUtil.toUpperCaseFirstOne(c);
				}
			}
			
		}
		return temp;
	}
	
	/**
	 * @param ctitle
	 * @return
	 * 得到生成的java列名
	 */
	public static String getClsName(String s){
		String temp = "";
		String[] cns = StringUtils.split(s, "_");
		for(int a = 0;a<cns.length;a++){
			String c = cns[a];
			temp =temp + CharUpperLowerUtil.toUpperCaseFirstOne(StringUtils.lowerCase(c));
		}
		return temp;
	}
	
	
	
}
