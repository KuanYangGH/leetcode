package dataset.protein;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 姚思雨师姐论文实验，蛋白质数据集处理
 * @author yangkuan
 * @date 2018/09/07
 */
public class Solution {

    private List<String> readTxt(String fileName) throws IOException {
        List<String> txtContent = new ArrayList<>();
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String line = in.readLine();
        while (line!=null){
            txtContent.add(line);
            line = in.readLine();
        }
        in.close();
        return txtContent;
    }

    private void writeTxt(String fileName,List<String> txtContent) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
        for(String str:txtContent){
            out.write(str);
            out.newLine();
        }
        out.close();
    }

    private String splitAndAdjustBySpace(String line){
        String[] entitiesAndRelations = line.split(" ");
        String[] eeR = new String[3];
        eeR[0] = entitiesAndRelations[0];
        eeR[1] = entitiesAndRelations[2];
        eeR[2] = entitiesAndRelations[1];
        String result = eeR[0]+" "+eeR[1]+" "+eeR[2];
        return result;
    }

    private List<String>[] divideTrainAndValidAndTest(List<String> txtContent){
        List<String> train = new ArrayList<>();
        List<String> valid = new ArrayList<>();
        List<String> test = new ArrayList<>();
        int len = txtContent.size();
        int trainLen = len/10*8;
        int validLen = len/10;
        int i=0;
        for(;i<trainLen;i++){
            train.add(txtContent.get(i));
        }
        for(;i<trainLen+validLen;i++){
            valid.add(txtContent.get(i));
        }
        for(;i<len;i++){
            test.add(txtContent.get(i));
        }
        List<String>[] result = new List[3];
        result[0] = train;
        result[1] = valid;
        result[2] = test;
        return result;
    }

    public void generateData() throws IOException {
        String fileName = "E:\\dataset\\思雨提供的蛋白质数据处理后的数据\\data.txt";
        List<String> txtContent = readTxt(fileName);
        List<String> newTxtContent = new ArrayList<>();
        for(String str:txtContent){
            newTxtContent.add(splitAndAdjustBySpace(str));
        }
        List<String>[] trainAndTest = divideTrainAndValidAndTest(newTxtContent);
        List<String> train = trainAndTest[0];
        List<String> valid = trainAndTest[1];
        List<String> test = trainAndTest[2];

        String trainfileName = "E:\\dataset\\思雨提供的蛋白质数据处理后的数据\\train.txt";
        String validfileName = "E:\\dataset\\思雨提供的蛋白质数据处理后的数据\\valid.txt";
        String testfileName = "E:\\dataset\\思雨提供的蛋白质数据处理后的数据\\test.txt";
        writeTxt(trainfileName,train);
        writeTxt(validfileName,valid);
        writeTxt(testfileName,test);
    }

    public static void main(String[] args) throws IOException {
        new Solution().generateData();
    }

}
