//package org.example;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.example.component.Column;
//import org.example.component.Row;
//import org.example.component.TableData;
//import org.example.component.column.ColumnType;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.stereotype.Controller;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.validation.Valid;
//import java.rmi.RemoteException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import static org.example.ClientApplication.webServiceSoap;
//
//
//@Controller
//public class DatabaseController {
//    @GetMapping("/")
//    public String index(Model model) {
//        List<TableData> tableData = getTableData();
//        model.addAttribute("tables", tableData);
//        return "index";
//    }
//
//    @GetMapping("/viewTable")
//    public String viewTable(@Valid int tableIndex, Model model) {
//        List<Row> rows = getRow(tableIndex);
//        List<TableData> tableData = getTableData();
//        List<Column> columns = getColumn(tableIndex);
//        model.addAttribute("tables", tableData);
//        model.addAttribute("thisTable", tableData.get(tableIndex));
//        model.addAttribute("columns", columns);
//        // Assuming tableIndex 0 is your test table
//        System.out.println(rows.size());
//        model.addAttribute("rows", rows);
//        return "viewTable";
//    }
//
//    @GetMapping("/addTable")
//    public String addTable(Model model) {
//        List<TableData> tableData = getTableData();
//        model.addAttribute("tables", tableData);
//        return "addTable";
//    }
//
//    @PostMapping("/addTable")
//    public String addTable(@Valid String name, Model model) {
//        webServiceSoap.createTable(name);
//        List<TableData> tableData = getTableData();
//        return "redirect:/viewTable?tableIndex=" + String.valueOf(tableData.size()-1); // Redirect to the view table page
//    }
//
//    @GetMapping("/addColumn")
//    public String addColumn(Model model, @RequestParam Map<String, String> allParams) {
//        model.addAttribute("tableIndex",allParams.get("tableIndex"));
//        ColumnType[] columnTypes = ColumnType.values();
//        List<String> types = new ArrayList<>();
//        for (int i = 0; i < columnTypes.length; i++) {
//            types.add(columnTypes[i].name());
//        }
//        model.addAttribute("types",types);
//        return "addColumn";
//    }
//
//    @PostMapping("/addColumn")
//    public String addColumn(@Valid String name, @Valid ColumnType columnType, @Valid String min, @Valid String max, Model model, @RequestParam Map<String, String> allParams){
//        int tableIndex = Integer.parseInt(allParams.get("tableIndex"));
//        webServiceSoap.addColumn(tableIndex, name, org.example.generated.ColumnType.fromValue(columnType.name()),min,max);
//        return "redirect:/viewTable?tableIndex=" + String.valueOf(tableIndex); // Redirect to the view table page
//    }
//
//    @PostMapping("/addRow")
//    public String addRow(
//        @RequestParam Map<String, String> allParams,
//        Model model, HttpServletRequest request) {
//        String referer = request.getHeader("Referer");
//        int tableIndex = Integer.parseInt(allParams.get("tableIndex"));
//        System.out.println(webServiceSoap.addRow(tableIndex));
//        return "redirect:" + referer; // Redirect to the view table page
//    }
//
//    @Transactional
//    @PostMapping("/deleteRow")
//    public String deleteRow(
//        @RequestParam Map<String, String> allParams,
//        Model model, HttpServletRequest request) {
//        String referer = request.getHeader("Referer");
//        int tableIndex = Integer.parseInt(allParams.get("tableIndex"));
//        int rowIndex = Integer.parseInt(allParams.get("rowIndex"));
//        System.out.println(webServiceSoap.deleteRow(tableIndex,rowIndex));
//        return "redirect:" + referer; // Redirect to the view table page
//    }
//
//    @Transactional
//    @PostMapping("/deleteColumn")
//    public String deleteColumn(
//        @RequestParam Map<String, String> allParams,
//        Model model, HttpServletRequest request) {
//        String referer = request.getHeader("Referer");
//        int tableIndex = Integer.parseInt(allParams.get("tableIndex"));
//        int columnIndex = Integer.parseInt(allParams.get("columnIndex"));
//        System.out.println(webServiceSoap.deleteColumn(tableIndex,columnIndex));
//        return "redirect:" + referer; // Redirect to the view table page
//    }
//
//    @Transactional
//    @PostMapping("/deleteTable")
//    public String deleteTable(
//        @RequestParam Map<String, String> allParams,
//        Model model, HttpServletRequest request) {
//        String referer = request.getHeader("Referer");
//        int tableIndex = Integer.parseInt(allParams.get("tableIndex"));
//        System.out.println(webServiceSoap.deleteTable(tableIndex));
//        return "redirect:/"; // Redirect to the view table page
//    }
//
//    @PostMapping("/editCell")
//    public String editCell(
//            @RequestParam Map<String, String> allParams,
//            Model model, HttpServletRequest request)  {
//        String referer = request.getHeader("Referer");
//
//
//        // Extracting rowIndex and columnIndex
//        int rowIndex = Integer.parseInt(allParams.get("rowIndex"));
//        int columnIndex = Integer.parseInt(allParams.get("columnIndex"));
//        int tableIndex = Integer.parseInt(allParams.get("tableIndex"));
//
//        // Extracting the dynamic value parameter
//        String newValue = allParams.get("value-" + rowIndex + "-" + columnIndex);
//
//        System.out.println(newValue);
//
//        // Check if newValue is present and not empty
//        if (newValue != null && !newValue.trim().isEmpty()) {
//            // Perform the edit operation
//            System.out.println(webServiceSoap.editCell(tableIndex, rowIndex, columnIndex, newValue));
//        }
//
//        return "redirect:" + referer; // Redirect to the view table page
//    }
//
//    @PostMapping("/removeDuplicates")
//    public String removeDuplicates(@RequestParam Map<String, String> allParams,
//        Model model, HttpServletRequest request) {
//        String referer = request.getHeader("Referer");
//        int tableIndex = Integer.parseInt(allParams.get("tableIndex"));
//        webServiceSoap.deleteDuplicateRows(tableIndex);
//        return "redirect:" + referer; // Redirect to the view table page
//    }
//}
