package study.example1.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import study.example1.domain.Transfer;
import study.example1.service.EntryService;
import study.example1.service.TransferService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/transfer")
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;
    private final EntryService entryService;

    @GetMapping("/new")
    public String makeTransfer(Model model) {
        model.addAttribute("transferForm", new TransferForm());
        return "transfer";
    }

    @PostMapping("/new")
    public String execTransfer(@Valid TransferForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/transfer/new";
        }

        entryService.entry(form.getFromId(), -form.getBalance());
        entryService.entry(form.getToId(), form.getBalance());
        transferService.transfer(form.getFromId(), form.getToId(), form.getBalance());

        return "redirect:/";
    }

    @GetMapping("/list")
    public String listTransfer(Model model) {
        List<Transfer> transfers = transferService.getList();
        model.addAttribute("transfers", transfers);
        return "transferList";
    }
}
