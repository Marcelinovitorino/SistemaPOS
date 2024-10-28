/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Model.Report;
import DAO.ReportDAO;

import java.math.BigDecimal;


public class ReportController {
    private ReportDAO reportDAO;

    public ReportController() {
        this.reportDAO = new ReportDAO();
    }

    // Método para obter o relatório completo
    public Report getRelatorioCompleto() {
        return reportDAO.getRelatorioCompleto();
    }

    // Método para obter o total de vendas
    public int getTotalVendas() {
        return reportDAO.getTotalVendas();
    }

    // Método para obter a quantidade total de produtos vendidos
    public int getQuantidadeTotal() {
        return reportDAO.getQuantidadeTotal();
    }

    // Método para obter a receita total
    public BigDecimal getReceitaTotal() {
        return reportDAO.getReceitaTotal();
    }

    // Método para obter a margem de lucro
    public BigDecimal getMargemLucro() {
        return reportDAO.getMargemLucro();
    }
}
