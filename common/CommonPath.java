package common;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CommonPath {

    /**
     *
     *
     * @return MAC, WINDOWS, LINUX, UNIX
     */
    public static String getOS(){
        String osName = System.getProperty("os.name");
        if(osName.contains("Mac")){
            return "MAC";
        }else if(osName.contains("Windows")){
            return "WINDOWS";
        }else if(osName.contains("Linux")){
            return "LINUX";
        }else if(osName.contains("Unix")){
            return "UNIX";
        }else{
            return "not defined OS";
        }

    }

    /**
     *
     * @return 만화디렉토리 경로
     */
    public static String getComicImgDir(){
        return System.getProperty("user.dir")+"/out/artifacts/jsp_war_exploded/images";
    }

    /**
     *
     * @param path
     * @return 파라미터 경로의 디렉터리 리스트
     */
    public List<String> getDirectoryList(String path){
        List<String> directoryList = new ArrayList<>();
        for (File info : Objects.requireNonNull(new File(path).listFiles())) {
            if (info.isDirectory()) {
                directoryList.add(info.getName());
            }
        }

        List<String> directoryListSorted = directoryList.stream().sorted(Comparator.naturalOrder()).toList();
        for(String str : directoryListSorted){
            System.out.println("str"+str);
        }

        return directoryList;
    }

    /**
     *
     * @param path
     * @param sortDivision
     * @return
     */
    public List<String> getSortDirectoryList(String path, String sortDivision){

        List<String> directoryList = new ArrayList<>();
        for (File info : Objects.requireNonNull(new File(path).listFiles())) {
            if (info.isDirectory()) {
                directoryList.add(info.getName());
            }
        }

        if(sortDivision.equals("ASC")){
            return directoryList.stream().sorted(Comparator.naturalOrder()).toList();
        }else if(sortDivision.equals("DESC")){
            return directoryList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        }else{
            return directoryList.stream().sorted(Comparator.naturalOrder()).toList();
        }
    }
}
