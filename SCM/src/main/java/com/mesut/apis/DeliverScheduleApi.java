package com.mesut.apis;

import com.mesut.pojo.DeliverySchedule;
import com.mesut.services.DeliveryScheduleService;
import com.mesut.services.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deliver-schedule")
public class DeliverScheduleApi extends GenericApi<DeliverySchedule> {
    private final DeliveryScheduleService deliScheService;

    @Autowired
    public DeliverScheduleApi(DeliveryScheduleService service) {
        super(service);
        this.deliScheService = service;
    }

    @GetMapping("/receipt-export/{receiptExportId}")
    public ResponseEntity<?> getScheduleByReceiptExportId(@PathVariable("receiptExportId") int receiptExportId) {
        List<DeliverySchedule> schedules = deliScheService.getDeliverScheduleByReceiptExportId(receiptExportId);
        if (schedules != null && !schedules.isEmpty()) {
            return ResponseEntity.ok(schedules);
        } else {
            return ResponseEntity.noContent().build(); 
        }
    }
}
