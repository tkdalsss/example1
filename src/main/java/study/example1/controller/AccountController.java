package study.example1.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import study.example1.domain.Account;
import study.example1.service.AccountService;

import java.util.List;

@Controller
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/new")
    public String createAccount(Model model) {
        model.addAttribute("accountForm", new AccountForm());
        return "account";
    }

    @PostMapping("/new")
    public String create(@Valid AccountForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "account";
        }

        Account account = Account.createAccount(form.getOwner(), form.getBalance(), form.getCurrency());

        accountService.createAccount(account);

        return "redirect:/"; // PRG
    }

    @GetMapping("/list")
    public String getList(Model model) {
        List<Account> accounts = accountService.getList();
        model.addAttribute("accounts", accounts);
        return "accountList";
    }
}
