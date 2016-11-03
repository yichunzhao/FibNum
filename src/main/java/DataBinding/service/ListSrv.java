/*
 * after handling line feed, tab, while space etc by xml adaptor; it still 
 * left a List but contains null or "". so we cannot determine empty by size
 * 
 */
package DataBinding.service;

import java.util.List;

/**
 *
 * @author YNZ
 */
public class ListSrv {

    public static boolean isEmpty(List<String> list) {
        boolean b = false;
        for (String s : list) {
            if (s == null) {
                b = b | true;
            }
        }
        return b;
    }

}
