package com.morrisons.common.helper;

import com.morrisons.common.utility.ApplicationContext;
import com.morrisons.sma.page_objects.mobile.old.AWS_S3Upload;
import org.apache.log4j.Logger;
import org.junit.Assert;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.zip.GZIPOutputStream;


public class FileHelper {

    private static final Logger log = Logger.getLogger(FileHelper.class);
    private static ArrayList arrInputData = new ArrayList();
    public static String readFile(URL filePath) {
        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get(filePath.toURI())));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return content;
    }

    public ArrayList getInputData(){
        return this.arrInputData;
    }
    public String readAndUpdateDATFile() throws IOException {
//        FileInputStream fstream = new FileInputStream("C://Users//Swati1500583//Downloads//ExceptionItemStock_YYYYMMDD_052020.dat");
        FileInputStream fstream = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//TestData//Input//" + "ExceptionItemStock_YYYYMMDD_052020.dat");
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String s;
        LocalDate currentDate = LocalDate.now();
        String sfile = "ExceptionItemStock_";
        String scurrentDate = currentDate.toString();
        scurrentDate = scurrentDate.replaceAll("-","");
        BufferedWriter outFstream = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "//src//test//resources//TestData//Output//" + sfile+  scurrentDate + "_052020.dat"));
        String sStore = ApplicationContext.STORE_ID;
        int sStrlen = sStore.length();
        if(sStrlen<3){
            for(int j=0;j<3-sStrlen;j++)
                sStore = sStore + " ";
        }
        while((s = br.readLine()) != null)
        {
            scurrentDate = scurrentDate.replaceAll("-","");
            String[] arrData = s.split(" ");
            s = s.replaceAll("STR", sStore);
            s = s.replaceAll("YYYYMMDD",scurrentDate);
            s = s.replaceAll("YYYY-MM-DD",currentDate.toString());
            arrInputData.add(arrData[0]);
            System.out.println(s);
            outFstream.write((s));
            outFstream.write(("\n"));
        }
        outFstream.flush();
        scurrentDate = sfile + scurrentDate + "_052020.dat";
        return scurrentDate;
    }
    //====================================================
    public String readAndUpdateDATFileNegativePrompt(String fileName) throws IOException {
        String[] arrfile = fileName.split("[.]");
        String sFileExt = arrfile[1];
        FileInputStream fstream = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//TestData//Input//" + fileName);
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String s;
        LocalDate currentDate = LocalDate.now().minusDays(1);
//        String sfile = "nb_prompted_count_";
        //===============================
        String[] arrfileName = fileName.split("getRunTime");
        String sfile,sfile1="";
        if(arrfileName.length>1){
            sfile = arrfileName[0];
            sfile1 = arrfileName[1];
        }
        else {
            sfile = arrfileName[0];
            sfile1 = sFileExt;
        }//"nb_prompted_count_";
        String[] arrFileName = sfile.split("[.]");
        sfile = arrFileName[0];
        //=====================================
        String sStore = ApplicationContext.STORE_ID;
        int sStrlen = sStore.length();
        if(sStrlen<3){
            for(int j=0;j<3-sStrlen;j++)
                sStore = sStore + " ";
        }
        String scurrentDate = currentDate.toString();
        scurrentDate = scurrentDate.replaceAll("-","");
        BufferedWriter outFstream = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "//src//test//resources//TestData//Output//" + sfile+  scurrentDate + sfile1));
        while((s = br.readLine()) != null)
        {
            scurrentDate = scurrentDate.replaceAll("-","");
            s = s.replaceAll("YYYYMMDD",scurrentDate);
            s = s.replaceAll("STR", sStore);
           // s = s.replaceAll("YYYY-MM-DD",currentDate.toString());
            System.out.println(s);
            outFstream.write((s));
            outFstream.write(("\n"));
        }
        outFstream.flush();
        scurrentDate = sfile+  scurrentDate + sfile1;
        return scurrentDate;
    }
    //=====================================================
    public String readAndUpdateDATFileBY(String fileName) throws IOException {
        String[] arrfile = fileName.split("[.]");
        String sFileExt = arrfile[1];
//        FileInputStream fstream = new FileInputStream("C://Users//Swati1500583//Downloads//" + fileName);
        FileInputStream fstream = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//TestData//Input//" + fileName);
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String s;
        LocalDate currentDate = LocalDate.now();
        LocalDate previousDate = LocalDate.now().minusDays(1);
        String[] arrfileName = fileName.split("getRunTime");
        String sfile,sfile1="";
        if(arrfileName.length>1){
            sfile = arrfileName[0];
            sfile1 = arrfileName[1];
        }
        else {
            sfile = arrfileName[0];
            sfile1 = sFileExt;
        }//"nb_prompted_count_";
        String[] arrFileName = sfile.split("[.]");
        sfile = arrFileName[0];
        String scurrentDate;
        if(sfile.contains("nb_blueyonder_orders")){
            scurrentDate = previousDate.toString();
            sfile1 = sfile1 + ".gz";
        }
        else{
            scurrentDate = currentDate.toString();
        }
        scurrentDate = scurrentDate.replaceAll("-","");
        if(sfile.contains("nb_blueyonder_orders")){
            GZIPOutputStream gos = new GZIPOutputStream(
                    new FileOutputStream(System.getProperty("user.dir") + "//src//test//resources//TestData//Output//" + sfile+  scurrentDate + sfile1));
//
            String sStore = ApplicationContext.STORE_ID;
            int sStrlen = sStore.length();
            if(sStrlen<3){
                for(int j=0;j<3-sStrlen;j++)
                sStore = sStore + " ";
            }
            while((s = br.readLine()) != null)
            {
                scurrentDate = scurrentDate.replaceAll("-","");
                String[] arrToken = s.split("\\s+");
                String items = arrToken[6];
                arrInputData.add(items);
//            s = s.replaceAll("YYYYMMDD",scurrentDate);

                s = s.replaceAll("STR", sStore);
                s = s.replaceAll("YYYY-MM-PD",previousDate.toString());
                s = s.replaceAll("YYYY-MM-CD",currentDate.toString());
                s = s.replaceAll("YYYY-MM-DD",previousDate.toString());
                System.out.println(s);
                gos.write((s).getBytes());
                gos.write(("\n").getBytes());
            }
            gos.flush();
            scurrentDate = sfile + scurrentDate + sfile1;
            return scurrentDate;
        }
        else {
            BufferedWriter outFstream = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "//src//test//resources//TestData//Output//" + sfile + scurrentDate + sfile1));
            while ((s = br.readLine()) != null) {
                scurrentDate = scurrentDate.replaceAll("-", "");
                String[] arrToken = s.split(",");
                String items = arrToken[0];
                String[] arrItems = items.split("~");
                arrInputData.add(arrItems[1]);
//            s = s.replaceAll("YYYYMMDD",scurrentDate);
                s = s.replaceAll("STR", ApplicationContext.STORE_ID);
                s = s.replaceAll("YYYY-MM-PD", previousDate.toString());
                s = s.replaceAll("YYYY-MM-CD", currentDate.toString());
                s = s.replaceAll("YYYY-MM-DD", previousDate.toString());
                System.out.println(s);
                outFstream.write((s));
                outFstream.write(("\n"));
            }
            outFstream.flush();
            scurrentDate = sfile + scurrentDate + sfile1;
            return scurrentDate;
        }
    }
    //========================================================
    public static void ValidateDataInputOutput() {
        LinkedHashMap arrOutputData = new LinkedHashMap();
        AWS_S3Upload oAWSUpld = new AWS_S3Upload();
        arrOutputData = oAWSUpld.getProductData();
        Set Keyset = arrOutputData.keySet();
        Iterator ite = Keyset.iterator();
        FileHelper oFH = new FileHelper();
        ArrayList arrInputData = oFH.getInputData();
        Iterator itt = arrOutputData.keySet().iterator();
        String sKey = null;
        while(itt.hasNext()){
            try {
                sKey = itt.next().toString();
                if (arrInputData.toString().contains(sKey)) {
                    Assert.assertTrue(arrInputData.toString().contains(sKey));
                }
            }
            catch(NullPointerException ne){
                log.trace(sKey + " Item not listed in the output file");
            }
        }
    }
    //===========================================================
}
