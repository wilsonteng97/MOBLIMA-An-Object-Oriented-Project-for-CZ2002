package Presenter;

import java.util.Date;
import java.util.HashMap;
import static Presenter.Presenter.*;
import Model.Holiday;

// TODO: Auto-generated Javadoc
/**
 * The Class PurchaseNOrder handles the setting of price based on holiday rates.
 */
public class PurchaseNOrder {
  
  /** The holiday list. */
  private static HashMap<String, Holiday> holidayList;
  
  /**
   * Instantiates a new purchase and order.
   */
  public PurchaseNOrder(){
  }
  
  /**
   * Gets the holiday based on the date parameter.
   *
   * @param time the time
   * @return the holiday
   */
  public static Holiday getHoliday(Date time) {
      return holidayList.get(formatTimeDate(time));
  }
}