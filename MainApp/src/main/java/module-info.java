module MainApp{
    uses edu.hneu.mjt.fomichovmaksym.service.Service;
    uses edu.hneu.mjt.fomichovmaksym.bank.Bank;
    requires jmp.cloud.bank.impl;
    requires jmp.cloud.service.impl;
    requires jmp.dto;
    exports edu.hneu.mjt.fomichovmaksym;
}
