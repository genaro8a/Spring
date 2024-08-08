using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ApiDestokenizacion
{
    public static class RequestExtensions

    {
        public static string AsString(this System.IO.Stream body)
        {
            using (var reader = new System.IO.StreamReader(body))
            {
                return reader.ReadToEnd();
            }
        }
    }
}
