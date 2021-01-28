package br.com.util;

import org.primefaces.PrimeFaces;

import javax.faces.context.FacesContext;

public class JSFUtil {
    public static void atualizarComponente(String componente) {
        PrimeFaces.current().ajax().update(componente);
    }

    public static void abrirDialog(String dlg) {
        PrimeFaces.current().executeScript("PF('" + dlg + "').show();");
    }

    public static void fecharDialog(String dlg) {
        PrimeFaces.current().executeScript("PF('" + dlg + "').hide();");
    }

    public static void redirectPage(String page) {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            String url = context.getExternalContext().getRequestContextPath();
            context.getExternalContext().redirect(url + "/pages/" + page + ".faces");
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            e.getStackTrace();
        }
    }
}