package Seguranca;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entidades.Usuario;

/**
 * Servlet Filter implementation class FiltroDeConfiguracao
 */
@WebFilter(description = "Filtro acesso a view de configuracao de ambiente", urlPatterns = { "/config/*" })
public class FiltroDeConfiguracao implements Filter {

   
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/*Versão para ambiente Windows */
		
		/**Verificar se os parametros necessários ao funcionamento do sistema estão configurados. 
		 * Caso já estejam não será permitido o acesso a view de configuração a usuário sem privilégios administrativos
		 **/
		ServletContext context = request.getServletContext(); 
		String path = context.getRealPath("/");
		//Util.Propriedades.obterLocalAplicacao(path+"WebContent/WEB-INF/propriedades/propriedades.txt");
		String arquivoPropriedades=path+"WEB-INF\\propriedades\\status.cfg";
		
		HttpServletResponse res = (HttpServletResponse)response;
		HttpServletRequest req =(HttpServletRequest) request;
		//Checar se objeto usuario estÃ¡ carregado na sessÃ£o 
		HttpSession session = req.getSession();
		
		Usuario usuario = (Usuario)session.getAttribute("usuario");
		//chain.doFilter(request, response);
		
		if (usuario==null)
		{
			try {
				System.out.println("Filtro de Configuracao de ambiente : "+arquivoPropriedades);
				String status = Util.Propriedades.lePropriedades("status", arquivoPropriedades);//if (localAplicacao==null)  chain.doFilter(request, response);
				//System.out.println("Propriedade :"+login);
				
				
				if (status.equals("ok"))
				{
					System.out.println("ErroAcessoRestrito[FiltroDeConfiguracao] "+"Tentativa de usuario :"
							+"(NAO_LOGADO)  acessar CONFIGURAÇÕES DE AMBIENTE bloqueada.\n AMBIENTE JÁ CONFIGURADO!" );
					res.sendRedirect("/Inventario/mensagens/naoautorizado.jsp");
				}
				else 
				{
					chain.doFilter(request, response);
					
				}
			} catch (IOException  e) {
				// TODO Auto-generated catch block
				System.out.println("Erro[FiltroDeConfiguracao]:"+e.getMessage());
			}
		}
		else
		{
			try	{
				System.out.println("Grupo de usuario"+usuario.getGrupoAcesso());
				if (usuario.getGrupoAcesso().equals("admin")) 
				{ 
					chain.doFilter(request, response);
				}else 
				{
					System.out.println("ErroAcessoRestrito[FiltroDeConfiguracao] "+"Tentativa de usuario :"
							+usuario.getNomeUsuario()+" Email:"+usuario.getEmail()
							+" acessar CONFIGURAÇÕES DE AMBIENTE\nbloqueada. Usuário não possui nível de acesso." );
					
					res.sendRedirect("/Inventario/mensagens/naoautorizado.jsp");
				}	
			} 
			catch (IOException | ServletException e)
			{
				System.out.println("Erro[FiltroConfiguracao]:"+e.getMessage());
			}
		}
		
	}
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
