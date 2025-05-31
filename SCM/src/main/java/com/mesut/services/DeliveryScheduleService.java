/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mesut.services;

import com.mesut.pojo.DeliverySchedule;
import java.util.List;

/**
 *
 * @author THANHTAIPC
 */
public interface DeliveryScheduleService extends GenericService<DeliverySchedule>{
    List<DeliverySchedule>getDeliverScheduleByReceiptExportId(int receiptExportId);
}
