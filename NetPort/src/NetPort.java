/**
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
    
    @Author Jorge Rivas
    @mail   jorge.shortys@gmail.com
 **/

import java.io.*;
import java.net.*;

/*
 * Este programa muestra las conexiones abiertas en un puerto sobre
 * un host determinado. Por defecto el host es localhost.
 */


public class NetPort
{
	public static void main(String[] args)
	{
		String host = args.length > 0 ? args[0] : "localhost";
		
		for (int i = 25; i < 10000; i++)
		{
			try
			{
				Socket s = new Socket(host, i);
				System.out.println("Hay un servicio ejecutandose en el puerto " + i + " sobre la ip: " + host);
				s.close();
			} 
			catch (UnknownHostException ex)
			{
				System.err.println(ex);
				break;
			} 
			catch (IOException ex)
			{
				// Aqui no deberia existir ningun sevricio ejecutandose.
			}
		}
	}
}
