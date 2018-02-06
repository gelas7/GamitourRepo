package com.proyecto.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.admin.delete.EliminarActividadesAccion;
import com.proyecto.admin.delete.EliminarClientesAccion;
import com.proyecto.admin.delete.EliminarItinerariosAccion;
import com.proyecto.admin.delete.EliminarMultimediasAccion;
import com.proyecto.admin.delete.EliminarNoticiasAccion;
import com.proyecto.admin.delete.EliminarParadasAccion;
import com.proyecto.admin.delete.EliminarPremiosAccion;
import com.proyecto.admin.delete.EliminarPruebasCulturalesAccion;
import com.proyecto.admin.delete.EliminarPruebasDeportivasAccion;
import com.proyecto.admin.delete.EliminarRolesAccion;
import com.proyecto.admin.insert.InsertarActividadesAccion;
import com.proyecto.admin.insert.InsertarClientesAccion;
import com.proyecto.admin.insert.InsertarItinerariosAccion;
import com.proyecto.admin.insert.InsertarMultimediasAccion;
import com.proyecto.admin.insert.InsertarNoticiasAccion;
import com.proyecto.admin.insert.InsertarParadasAccion;
import com.proyecto.admin.insert.InsertarPremiosAccion;
import com.proyecto.admin.insert.InsertarPruebasCulturalesAccion;
import com.proyecto.admin.insert.InsertarPruebasDeportivasAccion;
import com.proyecto.admin.insert.InsertarRolesAccion;
import com.proyecto.admin.main.MostrarAdminAccion;
import com.proyecto.admin.update.ModificarActividadesAccion;
import com.proyecto.admin.update.ModificarClientesAccion;
import com.proyecto.admin.update.ModificarItinerariosAccion;
import com.proyecto.admin.update.ModificarMultimediasAccion;
import com.proyecto.admin.update.ModificarNoticiasAccion;
import com.proyecto.admin.update.ModificarParadasAccion;
import com.proyecto.admin.update.ModificarPremiosAccion;
import com.proyecto.admin.update.ModificarPruebasCulturalesAccion;
import com.proyecto.admin.update.ModificarPruebasDeportivasAccion;
import com.proyecto.admin.update.ModificarRolesAccion;

public abstract class Accion {

	public abstract String ejecutar(HttpServletRequest request, HttpServletResponse response);

	public static Accion getAccion(String tipo) {
		Accion accion = null;

		switch (tipo) {

		case "MostrarAdmin":
			accion = new MostrarAdminAccion();
			break;
		case "InsertarNoticias":
			accion = new InsertarNoticiasAccion();
			break;
		case "EliminarNoticias":
			accion = new EliminarNoticiasAccion();
			break;
		case "ModificarNoticias":
			accion = new ModificarNoticiasAccion();
			break;
		case "InsertarItinerarios":
			accion = new InsertarItinerariosAccion();
			break;
		case "EliminarItinerarios":
			accion = new EliminarItinerariosAccion();
			break;
		case "ModificarItinerarios":
			accion = new ModificarItinerariosAccion();
			break;
		case "InsertarRoles":
			accion = new InsertarRolesAccion();
			break;
		case "EliminarRoles":
			accion = new EliminarRolesAccion();
			break;
		case "ModificarRoles":
			accion = new ModificarRolesAccion();
			break;
		case "InsertarClientes":
			accion = new InsertarClientesAccion();
			break;
		case "EliminarClientes":
			accion = new EliminarClientesAccion();
			break;
		case "ModificarClientes":
			accion = new ModificarClientesAccion();
			break;
		case "InsertarActividades":
			accion = new InsertarActividadesAccion();
			break;
		case "EliminarActividades":
			accion = new EliminarActividadesAccion();
			break;
		case "ModificarActividades":
			accion = new ModificarActividadesAccion();
			break;
		case "InsertarParadas":
			accion = new InsertarParadasAccion();
			break;
		case "EliminarParadas":
			accion = new EliminarParadasAccion();
			break;
		case "ModificarParadas":
			accion = new ModificarParadasAccion();
			break;
		case "InsertarPruebasDeportivas":
			accion = new InsertarPruebasDeportivasAccion();
			break;
		case "EliminarPruebasDeportivas":
			accion = new EliminarPruebasDeportivasAccion();
			break;
		case "ModificarPruebasDeportivas":
			accion = new ModificarPruebasDeportivasAccion();
			break;
		case "InsertarPruebasCulturales":
			accion = new InsertarPruebasCulturalesAccion();
			break;
		case "EliminarPruebasCulturales":
			accion = new EliminarPruebasCulturalesAccion();
			break;
		case "ModificarPruebasCulturales":
			accion = new ModificarPruebasCulturalesAccion();
			break;
		case "InsertarPremios":
			accion = new InsertarPremiosAccion();
			break;
		case "ModificarPremios":
			accion = new ModificarPremiosAccion();
			break;
		case "EliminarPremios":
			accion = new EliminarPremiosAccion();
			break;
		case "InsertarMultimedias":
			accion = new InsertarMultimediasAccion();
			break;
		case "ModificarMultimedias":
			accion = new ModificarMultimediasAccion();
			break;
		case "EliminarMultimedias":
			accion = new EliminarMultimediasAccion();
			break;
			
		default:
			System.out.println("Error en Accion.java");
			break;
		}

		return accion;
	}
}
