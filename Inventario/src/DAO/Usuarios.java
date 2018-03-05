package DAO;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Entidades.Usuario;

public class Usuarios 
{
	private List<Usuario> listaDeUsuarios=new ArrayList<Usuario>();
	public  Usuario getUsuario(Connection conn, String nomeUsuario,String acesso)
	{
		Usuario usuario = new Usuario();
		try
		{	PreparedStatement pstmt = conn.prepareStatement("select * from usuarios where nome_usuario = ? and acesso= ?");	
		    pstmt.setString(1, nomeUsuario);
		    pstmt.setString(2, acesso);
		    ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
			{	 
				do
				{	
					usuario.setNomeUsuario(rs.getString("nome_usuario"));
					usuario.setChaveAcesso(rs.getString("acesso"));
					usuario.setGrupoAcesso(rs.getString("grupo_acesso"));
					usuario.setEmail(rs.getString("email"));
					usuario.setTelefone(rs.getString("telefone"));
				}
				while(rs.next());
			}
			rs.close();
			pstmt.close();
			System.out.println(usuario.toString());
		}	
		catch (SQLException e)
		{	e.printStackTrace();
		System.out.println("Erro[Usuarios:getUsuarios]:"+e.getMessage());
			
		}
		return usuario;
		
	}
	
	@SuppressWarnings("rawtypes")
	public void setListaDeUsuarios(Connection conn)
	{
		Usuario usuario;
		try
		{
				PreparedStatement pstmt = conn.prepareStatement("select * from usuarios");
				ResultSet rs = pstmt.executeQuery();
				if(rs.next())
				{
					do 
					{
						usuario=new Usuario();
						usuario.setNomeUsuario(rs.getString("nome_usuario"));
						usuario.setChaveAcesso(null);
						usuario.setGrupoAcesso(rs.getString("grupo_acesso"));
						usuario.setEmail(rs.getString("email"));
						usuario.setTelefone(rs.getString("telefone"));
						listaDeUsuarios.add(usuario);
						
					}while(rs.next());
				}
				rs.close();
				pstmt.close();
						
		}
		catch(SQLException e )
		{
			System.out.println("Erro[Usuarios:setListaDeUsuarios]:"+e.getMessage());
		}
		
	}
	public boolean isRoot(Connection conn,Usuario root)
	{
		boolean admin=false;
		try
		{
			PreparedStatement pstmt = conn.prepareStatement("select * from usuarios where nome_usuario=? and acesso=? ");
			pstmt.setString(1, root.getNomeUsuario());
		    pstmt.setString(2, root.getChaveAcesso());
		    ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{	 
				do
				{	
					if (rs.getString("grupo_acesso")=="admin") admin=true;
				}
				while(rs.next());
			}
			rs.close();
			pstmt.close();
			
		}
		catch(SQLException e)
		{
			System.out.println("Erro[Usuarios:isRoot]:"+e.getMessage());e.getMessage();
		}
		return admin;
	}
	public List getListaDeUsuarios()
	{
		return this.listaDeUsuarios;
	}
	public boolean atualizarChaveAcesso(Connection conn,Usuario usuario,String novaChave)
	{
		try
		{
			PreparedStatement pstmt=conn.prepareStatement("update usuarios set acesso=? where nome_usuario=?");
			pstmt.setString(1, novaChave);
			pstmt.setString(2, usuario.getNomeUsuario());
			int n=pstmt.executeUpdate();
			pstmt.close();
			return n==1;
			
		}
		catch(SQLException e)
		{
			System.out.println("Erro[Usuarios:atualizarChaveAcesso]:"+e.getMessage());
		}
		return false;
	}

	public boolean atualizarRegistro(Connection conn, Usuario novoUsuario) 
	{
		try 
		{
			PreparedStatement pstmt=conn.prepareStatement
					("update usuarios set "
							//+ "acesso=?,"
							+ "grupo_acesso=?,"
							+ "email=?,"
							+ "telefone=? "
							+ "where nome_usuario=?");
			
			//pstmt.setString(1, novoUsuario.getChaveAcesso());
			pstmt.setString(1, novoUsuario.getGrupoAcesso());
			pstmt.setString(2, novoUsuario.getEmail());
			pstmt.setString(3, novoUsuario.getTelefone());
			pstmt.setString(4, novoUsuario.getNomeUsuario());
			
			int n=pstmt.executeUpdate();
			pstmt.close();
			return n==1;
		}
		catch (SQLException e) 
		{
			System.out.println("Erro[Usuarios:atualizarRegistro]:"+e.getMessage());
		}
		return false;
	}

	public boolean incluir(Connection conn, Usuario novoUsuario) 
	{
		try 
		{
			PreparedStatement pstmt = conn.prepareStatement("insert into usuarios (nome_usuario,acesso,grupo_acesso,email,telefone) values(?,?,?,?,?)");
			pstmt.setString(1,novoUsuario.getNomeUsuario());
			pstmt.setString(2,"default");
			pstmt.setString(3, novoUsuario.getGrupoAcesso());
			pstmt.setString(4, novoUsuario.getEmail());
			pstmt.setString(5,novoUsuario.getTelefone());
			
			int n=pstmt.executeUpdate();
			pstmt.close();
			return n==1;
		} 
		catch (SQLException e) 
		{
			System.out.println("Erro[Usuarios:incluir]:"+e.getMessage());
		}
		return false;
	}
	
}
	

