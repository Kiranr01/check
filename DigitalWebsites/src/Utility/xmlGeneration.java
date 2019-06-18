package Utility;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Node;

public class xmlGeneration 
{
	public static void main(String args[]) throws ParserConfigurationException, TransformerException, IOException 
	{
		String HubExcel="HubSheet";
		String testsetsheetName = "TestSet";
		Data obj=new Data();
		int func=obj.rownum(HubExcel,testsetsheetName);
		ReadExcel readExcel=new ReadExcel();
		
		int noderow1=obj.rownum(HubExcel, "Node");
		int threadcnt=0;
		
		for (int Excelnamerow1=1;Excelnamerow1	<noderow1;Excelnamerow1++)
		{
			readExcel.openExcel(HubExcel);
			new ReadExcel().excelRead("Node",Excelnamerow1);
			String Node_Run = ReadExcel.getValue("Node_Run");
			
			if(Node_Run.equalsIgnoreCase("Y"))
			{
				threadcnt+=1;
			}
		}
		String thrdcnt=threadcnt+"";
		for (int j =1;j<func;j++)
		{
			readExcel.openExcel(HubExcel);
			
			new ReadExcel().excelRead(testsetsheetName,j);		
			
			String Functionality = ReadExcel.getValue("Functionality");
	        			
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	        		
			Document doc = docBuilder.newDocument();
			Node rootElement = (Node) doc.createElement("suite");
			doc.appendChild((Node) rootElement);

			Attr Suite_Name = doc.createAttribute("name");
			Suite_Name.setValue("SEG Roadrunner");
			((org.w3c.dom.Element) rootElement).setAttributeNode(Suite_Name);
	        		
			Attr Suite_Parallel = doc.createAttribute("parallel");
			Suite_Parallel.setValue("tests");
			((org.w3c.dom.Element) rootElement).setAttributeNode(Suite_Parallel);
			
			
			Attr ThreadCount = doc.createAttribute("thread-count");
			ThreadCount.setValue(thrdcnt);
			((org.w3c.dom.Element) rootElement).setAttributeNode(ThreadCount);
			
			int noderow=obj.rownum(HubExcel, "Node");
			
			for (int Excelnamerow=1;Excelnamerow<noderow;Excelnamerow++)
			{
				readExcel.openExcel(HubExcel);
				new ReadExcel().excelRead("Node",Excelnamerow);
				String Node_Run = ReadExcel.getValue("Node_Run");
				
				if(Node_Run.equalsIgnoreCase("Y"))
				{
					String NodeExcelName=ReadExcel.getValue("Node_ExcelName");
					String Node_URL=ReadExcel.getValue("Node_URL");
				
					
					new Readexcel_RowName().excelRead(HubExcel,testsetsheetName, Functionality);
					
					String TestSet_Name = Readexcel_RowName.getValue("TestSet_Name");
					
					new Readexcel_RowName().excelRead(NodeExcelName,"Global",Functionality);	
					String Chrome= Readexcel_RowName.getValue("Chrome(Y/N)");
					String IE= Readexcel_RowName.getValue("IE(Y/N)");
					String Safari= Readexcel_RowName.getValue("Safari(Y/N)");
					String Winndixie= Readexcel_RowName.getValue("Winndixie(Y/N)");
					String Bilo= Readexcel_RowName.getValue("Bilo(Y/N)");
					String Harveys= Readexcel_RowName.getValue("Harveys(Y/N)");
					String BrowserType = null;
					String Banner = null;
					if(Chrome.equalsIgnoreCase("y"))
					{
						BrowserType="Chrome";	
					}
					else if(IE.equalsIgnoreCase("y"))
					{
						BrowserType="IE";	
					}
					else if(Safari.equalsIgnoreCase("y"))
					{
						BrowserType="Safari";
					}
					if(Winndixie.equalsIgnoreCase("y"))
					{
						Banner = "Winndixie";
					
					}
					else if(Bilo.equalsIgnoreCase("y"))
					{
						Banner = "Bilo";
					
					}
					else if(Harveys.equalsIgnoreCase("y"))
					{
						Banner = "Harveys";	
					}
					
					int s=obj.rownum(NodeExcelName, Functionality);
					
					new Readexcel_RowName().excelRead(NodeExcelName,"Global",Functionality);		
				
						
					String Brw = BrowserType;
					String conc = Functionality+"__"+ NodeExcelName+"__"+Brw+"__"+Banner;
				
					Node test = (Node) doc.createElement("test");
					((Node) rootElement).appendChild((Node) test);
								
					Attr attr = doc.createAttribute("name");
					attr.setValue(conc);
					((org.w3c.dom.Element) test).setAttributeNode(attr);
									
					Node Parameter = (Node) doc.createElement("parameter");
					((Node) test).appendChild((Node) Parameter);
					Attr browserSetName = doc.createAttribute("name");
					browserSetName.setValue("BrowserType");
					((org.w3c.dom.Element) Parameter).setAttributeNode(browserSetName);
					Attr browserval = doc.createAttribute("value");
					browserval.setValue(BrowserType);
					((org.w3c.dom.Element) Parameter).setAttributeNode(browserval);

					Node Parameter2 = (Node) doc.createElement("parameter");
					((Node) test).appendChild((Node) Parameter2);
					Attr MarketSetName = doc.createAttribute("name");
					MarketSetName.setValue("Banner");		
					((org.w3c.dom.Element) Parameter2).setAttributeNode(MarketSetName);
					Attr Marketval = doc.createAttribute("value");
					Marketval.setValue(Banner);
					((org.w3c.dom.Element) Parameter2).setAttributeNode(Marketval);
					
					 Node Parameter3 = (Node) doc.createElement("parameter");
		             ((Node) test).appendChild((Node) Parameter3);
		             Attr nodeurl1 = doc.createAttribute("name");
		             nodeurl1.setValue("node_ip");
		             ((org.w3c.dom.Element) Parameter3).setAttributeNode(nodeurl1);
		             Attr nodeurlval = doc.createAttribute("value");
		             nodeurlval.setValue(Node_URL);
		             ((org.w3c.dom.Element) Parameter3).setAttributeNode(nodeurlval);
							
		             Node Parameter4 = (Node) doc.createElement("parameter");
		             ((Node) test).appendChild((Node) Parameter4);
		             Attr ExcelName = doc.createAttribute("name");
		             ExcelName.setValue("TestDataExcel");
		             ((org.w3c.dom.Element) Parameter4).setAttributeNode(ExcelName);
		             Attr ExcelNameval = doc.createAttribute("value");
		             ExcelNameval.setValue(NodeExcelName);
		             ((org.w3c.dom.Element) Parameter4).setAttributeNode(ExcelNameval);

		             
		             Node Classes = (Node) doc.createElement("classes");
		             ((Node) test).appendChild((Node) Classes);
				
								
		             Node Class = (Node) doc.createElement("class");
		             ((Node) Classes).appendChild((Node) Class);
				
		             Attr Classname_val = doc.createAttribute("name");
		             Classname_val.setValue(TestSet_Name);
		             ((org.w3c.dom.Element) Class).setAttributeNode(Classname_val);
				
		             Node methods = (Node) doc.createElement("methods");
		             ((Node) Class).appendChild((Node) methods);
						
					
		             for (int i = 1; i < s; i++) 
		             {
					
		            	 // adding method name methods include
						
		            	 Node include = (Node) doc.createElement("include");
		            	 ((Node) methods).appendChild((Node) include);
		            	 readExcel.openExcel(NodeExcelName);
		            	
		            	 new ReadExcel().excelRead(Functionality,i);		
						
		            	 String Testcase_Name = ReadExcel.getValue("Testcase_Name");
					
		            	 Attr method_val = doc.createAttribute("name");
		            	 method_val.setValue(Testcase_Name);
		            	 ((org.w3c.dom.Element) include).setAttributeNode(method_val);
						              
		             }
		             
		             TransformerFactory transformerFactory = TransformerFactory.newInstance();
		             Transformer transformer = transformerFactory.newTransformer();
		             transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		             transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		             transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		             DOMImplementation domImpl = doc.getImplementation();
		             DocumentType doctype = domImpl.createDocumentType("doctype", "SYSTEM",
		            			 "http://testng.org/testng-1.0.dtd");
		             transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, doctype.getPublicId());
		             transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, doctype.getSystemId());
		             DOMSource source = new DOMSource(doc);
		             StreamResult result = new StreamResult(new File(System.getProperty("user.dir")+"\\Run\\"+Functionality+".xml"));
		            	 transformer.transform(source, result);           
				}
		    }
		}
		System.out.println("XML Generated. Please refresh RUN folder and open");
	}
}



