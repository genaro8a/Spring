
using System;
using System.Security.Cryptography.X509Certificates;
using Nancy.Hosting.Self;
using Nancy;
using Owin;
namespace ApiDestokenizacion
{
     class Program
    {
        static void Main(string[] args)
        {
            string baseUrl = "https://localhost:1234/";

            var hostConfig = new HostConfiguration
            {
                UrlReservations = new UrlReservations { CreateAutomatically = true },
                RewriteLocalhost = true // Asegurar que `localhost` sea redirigido correctamente
            };

            try
            {
                using (var host = new NancyHost(new Uri(baseUrl), new DefaultNancyBootstrapper(), hostConfig))
                {
                    host.Start();
                    Console.WriteLine($"Running on {baseUrl}");
                    Console.ReadKey(); // Esperar a que se presione una tecla para detener el servidor
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine("An error occurred while starting the application.");
                Console.WriteLine(ex.Message);
            }
        }
    }
}
