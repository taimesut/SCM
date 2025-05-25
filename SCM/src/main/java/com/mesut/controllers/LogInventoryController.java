/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.controllers;

import com.mesut.constants.RepositoryConstants;
import com.mesut.pojo.LogInventory;
import com.mesut.services.LogInventoryService;
import com.mesut.services.ReceiptExportService;
import com.mesut.services.ReceiptImportService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author THANHTAIPC
 */
@Controller
public class LogInventoryController {

    // Đổi
    private static final String NAME = "log-inventory";

    // Không Đụng
    private static final String PREFIX_URL = PrefixUrl.PREFIX_URL;
    private static final String URL_BASE = PREFIX_URL + "/" + NAME;

    private static final String URL_LIST_VIEW = URL_BASE;
    private static final String URL_ADD_VIEW = URL_BASE + "/add";
    private static final String URL_ADD_PROCESS = URL_BASE + "/add";
    private static final String URL_UPDATE_VIEW = URL_BASE + "/{id}";
    private static final String URL_UPDATE_PROCESS = URL_BASE + "/update";
    private static final String URL_DELETE_PROCESS = URL_BASE + "/delete/{id}";

    private static final String RETURN_LIST_VIEW = "manage/" + NAME;

    private static final String REDIRECT_ADD_SUCCESS = "redirect:" + URL_BASE + "/add?addSuccess";
    private static final String REDIRECT_ADD_ERROR = "redirect:" + URL_BASE + "/add?addError";
    private static final String REDIRECT_UPDATE_SUCCESS = "redirect:" + URL_BASE + "/%d?updateSuccess";
    private static final String REDIRECT_UPDATE_ERROR = "redirect:" + URL_BASE + "/%d?updateError";
    private static final String REDIRECT_DELETE_SUCCESS = "redirect:" + URL_BASE + "?deleteSuccess";
    private static final String REDIRECT_DELETE_ERROR = "redirect:" + URL_BASE + "?deleteError";

    private static final String FORM = "forms/form-" + NAME;

//    Đổi Service
    @Autowired
    private LogInventoryService mainService;

    @GetMapping(URL_LIST_VIEW)
    public String listView(Model model, @RequestParam Map<String, String> params) {
        // tổng số trang lấy theo tìm kiếm hiện tại
        int totalPages = (int) Math.ceil((double) this.mainService.countWithFilter(params) / RepositoryConstants.DEFAULT_PAGE_SIZE);

        // số trang lấy theo tìm kiếm hiện tại
        int page = -1;
        if (totalPages > 0) {
            page = Integer.parseInt(params.getOrDefault("page", "1").toString());

        } else {
            page = Integer.parseInt(params.getOrDefault("page", "0").toString());

        }
        // các tham số tìm kiếm
        String kw = params.getOrDefault("kw", "");
        String kw2 = params.getOrDefault("kw2", "");
        String kw3 = params.getOrDefault("kw3", "");
        String kw4 = params.getOrDefault("kw4", "");
        String kw5 = params.getOrDefault("kw5", "");

        model.addAttribute("list", this.mainService.getAllWithFilter(params));
        model.addAttribute("name", NAME);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("page", page);
        model.addAttribute("kw", kw);
        model.addAttribute("kw2", kw2);
        model.addAttribute("kw3", kw3);
        model.addAttribute("kw4", kw4);
        model.addAttribute("kw5", kw5);

        return RETURN_LIST_VIEW;
    }

}
