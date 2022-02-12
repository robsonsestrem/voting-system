package unicesumar;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jboss.weld.module.web.HttpServletRequestBean;

@WebServlet(urlPatterns = {"/candidato"})
public class CandidatoServlet extends HttpServlet {

    List<Candidato> candidatos = new ArrayList<>();

    protected void doGet(HttpServletRequestBean request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Chamou pelo método GET.");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String votos = request.getParameter("votos");
        int votacao = Integer.parseInt(votos);

        for (int i = 0; i < 5; i++) {
            String input = request.getParameter("candidato" + String.valueOf(i + 1));
            Candidato candidato = new Candidato(input);
            candidatos.add(candidato);
        }

        Random gerador = new Random();

        int maior = 0;
        String vencedor = "";
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");  
        out.println("<head>"
                + "<title>Resultado</title>"
                + "<meta charset=\"utf-8\">"
                + "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">"
                + "<link rel=\"stylesheet\" href=\"recursos/css/StyleSheet.css\">"
                + "</head>");
        out.println("<body>");
        out.println("<header style=\"position: relative; top: 1px; background-color: steelblue;\n"
                + "border-top-left-radius: 15px;border-top-right-radius: 15px;height: 40px;\">"
                + "<h1 style=\"font-family: Microsoft PhagsPa;font-size: 25px;color: #FFFFFF;text-align: center;\">"
                + "Contagem de Votos</h1></header>");
        out.println("<div style=\"border-left: 1px solid #888;\n"
                + "    border-right: 1px solid #888;\n"
                + "    border-bottom: 1px solid #888;\n"
                + "    position: relative;\n"
                + "    top: -10px;\n"
                + "    padding-top: 10px;\n"
                + "    padding-left: 20px;\n"
                + "    padding-bottom: 20px;\n"
                + "    box-shadow: 3px 3px 3px #444;\n"
                + "    font-family: Verdana, Arial, sans-serif;\n"
                + "    font-size: 0.8em;      \">");

        out.println("<table border=0 cellpadding=7 cellspacing=3 style=\"width:40%\">");
        out.println("<tr bgcolor=#3366ff><td>Candidato</td> <td>Votos</td></tr><br><br/>");
        for (int i = 0; i < candidatos.size(); i++) {
            out.println("<tr>");
            if (i == 4) {
                //pega a sobra
                out.println("<td>" + candidatos.get(i).getNomeCandidato().toUpperCase() + "</td><td>" + votacao + "</td><br/>");
                if (votacao > maior) {
                    maior = votacao;
                    vencedor = candidatos.get(i).getNomeCandidato();
                }
            } else {
                int votosCandi = gerador.nextInt(votacao);
                out.println("<td>" + candidatos.get(i).getNomeCandidato().toUpperCase() + "</td><td>" + votosCandi + "</td><br/>");
                if (votosCandi > maior) {
                    maior = votosCandi;
                    vencedor = candidatos.get(i).getNomeCandidato();
                }
                votacao = votacao - votosCandi;
            }
            out.println("</tr>");
        }
        out.println("</table>");

        out.println("<br/>");
        out.println("<p style=\"font-family: Verdana, Arial, sans-serif;font-size: 1.8em;\">O vencedor foi: " + vencedor.toUpperCase() + ", totalizando " + maior + " votos." + "</p><br/>");
        out.println("<br/><br/>");
        out.println("<a href=\"candidato.jsp\"><button type=\"button\">Voltar</button></a>");

        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
        out.close();
        //limpar lista para novos cálculos
        if (candidatos != null) {
            candidatos.clear();
        }
    }

}
