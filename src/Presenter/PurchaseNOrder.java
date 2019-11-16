package Presenter;

import java.util.Date;
import java.util.HashMap;
import static Presenter.Presenter.*;
import Model.Holiday;

public class PurchaseNOrder {
  private static HashMap<String, Holiday> holidayList;
  
  public PurchaseNOrder(){
  }
  public static Holiday getHoliday(Date time) {
      HashMap<String, Holiday> holidayList = getHolidayList();
      return holidayList.get(formatTimeDate(time));
  }
  public static HashMap<String, Holiday> getHolidayList() {
      
	  return holidayList;
  }

}