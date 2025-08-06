package org.example.livecoding;

import java.util.List;
import java.util.Map;

/**
 * @author salat
 * check 271 key first if it is not null satisfy test demands
 * if DATE_START is after 2008 year - you have to add entry "OLDER_THAN_2008", "Y"
 * remove all entries with null value
 *  if ADVERTISING_DATA has list element with PURPOSE=8 and "PROD.TYPE" != "SOME_TYPE_1" add entry to the common map ("EXTRA", "Y")
 */
public class TaskMap {

    public  void preProcess(Map map) {
        List<Map<Object, Object>> aa = (List<Map<Object, Object>>)map.get("ADVERTISING_DATA");
        System.out.println(aa.get(2).get("PURPOSE"));
        System.out.println((map.get("ADVERTISING_DATA")));
    }

   public enum ErrorCodes {
        // this should be error codes
   }
}
