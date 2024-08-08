using Nancy;

namespace ApiDestokenizacion
{
    public class Modulo:NancyModule
    {
        public Modulo()
        {
            Get("/", _ => "Hello, World!");

            Get("/hello/{name}", parameters => $"Hello, {parameters.name}");

            Post("/data", parameters =>
            {
                var data = this.Request.Body.AsString();
                return $"You posted: {data}";
            });
        }
    }
}
