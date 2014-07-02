package pro.francisco.java.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;

public class TextUtil {

    /*
    public static void main(String[] params) {
        System.err.println(info.netinho.util.Text.reduzirNome("RAIMUNDO  FELIX ALVES DE OLIVEIRA", 30));
        System.err.println(info.netinho.util.Text.generatePassword());
    }*/

    public static boolean hasContent(String s) {
        return (s != null) && (s.trim().length() > 0);
    }

    public static boolean hasString(String $haystack, String $needle) {
        String found = $haystack.substring(0, $haystack.indexOf($needle) + 1);
        return !found.isEmpty();
    }

    public static String retirarAcentos(String s) {
        if (s == null) {
            return new String();
        }
        String s1 = "àáâãäèéêëìíîïòóôõöùúûüýÿçñÀÁÂÃÄÈÉÊËÌÍÎÒÓÔÕÖÙÚÛÜÝÇÑ";
        String s2 = "aaaaaeeeeiiiiooooouuuuyycnAAAAAEEEEIIIOOOOOUUUUYCN";
        char[] retorno = s.toCharArray();
        if (s.length() > 0) {
            for (int i = 0; i < s.length(); i++) {
                int j = 0;

                while (j < s1.length()) {
                    if (retorno[i] == s1.charAt(j)) {
                        retorno[i] = s2.charAt(j);
                        break;
                    }
                    j++;
                }
            }
        }

        return new String(retorno);
    }

    public static String replicate(char c, int size) {
        String r = "";
        while (r.length() < size) {
            r = r + c;
        }
        return r;
    }

    public static int countOccurrences(String haystack, char needle) {
        int count = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle) {
                count++;
            }
        }
        return count;
    }

    public static String[] splitPreserveAllTokens(String str, String separatorChars) {
        return splitWorker(str, separatorChars, -1, true);
    }

    private static String[] splitWorker(String str, String separatorChars, int max, boolean preserveAllTokens) {
        if (str == null) {
            return null;
        }

        int len = str.length();
        if (len == 0) {
            return new String[0];
        }

        List<String> list = new ArrayList<String>();
        int sizePlus1 = 1;
        int i = 0;
        int start = 0;
        boolean match = false;
        boolean lastMatch = false;

        if (separatorChars == null) {
            while (i < len) {
                if (Character.isWhitespace(str.charAt(i))) {
                    if ((match) || (preserveAllTokens)) {
                        //lastMatch = true;
                        if (sizePlus1++ == max) {
                            i = len;
                            //lastMatch = false;
                        }
                        list.add(str.substring(start, i));
                        match = false;
                    }
                    i++;
                    start = i;
                    continue;
                }
                lastMatch = false;
                match = true;
                i++;
            }
        }

        if (separatorChars != null) {
            if (separatorChars.length() == 1) {
                char sep = separatorChars.charAt(0);
                while (i < len) {
                    if (str.charAt(i) == sep) {
                        if ((match) || (preserveAllTokens)) {
                            //lastMatch = true;
                            if (sizePlus1++ == max) {
                                i = len;
                                //lastMatch = false;
                            }
                            list.add(str.substring(start, i));
                            match = false;
                        }
                        i++;
                        start = i;
                        continue;
                    }
                    lastMatch = false;
                    match = true;
                    i++;
                }
            } else {
                while (i < len) {
                    if (separatorChars.indexOf(str.charAt(i)) >= 0) {
                        if ((match) || (preserveAllTokens)) {
                            //lastMatch = true;
                            if (sizePlus1++ == max) {
                                i = len;
                                //lastMatch = false;
                            }
                            list.add(str.substring(start, i));
                            match = false;
                        }
                        i++;
                        start = i;
                        continue;
                    }
                    lastMatch = false;
                    match = true;
                    i++;
                }
            }
        }

        if ((match) || ((preserveAllTokens) && (lastMatch))) {
            list.add(str.substring(start, i));
        }

        return (String[]) (String[]) list.toArray(new String[list.size()]);
    }

    public static boolean isEmpty(String s) {
        return (s == null) || (s.trim().isEmpty());
    }

    public static String utf8encode(String string) throws UnsupportedEncodingException {
        return new String(string.getBytes("ISO-8859-1"), "UTF-8");
    }

    public static String utf8decode(String string) throws UnsupportedEncodingException {
        return new String(string.getBytes("UTF-8"), "ISO-8859-1");
    }

    /**
     * Responsavel por reduzir o nome com a quantidade de caracteres informada,
     * sem cortar pedaco do nome e simplificando os sobrenomes: Pedro P. Souza
     *
     * @author Tayron Miranda <falecom@tayronmiranda.com.br>
     * @author Francisco Ernesto Teixeira <fco.ernesto@gmail.com>
     * @param texto Texto
     * @param tamanho Quantidade de caracteres
     * @return Texto limitado aos caracteres sem cortar palavras abrevia os
     * nomes do meio
     * @since 02/04/2012
     */
    public static String reduzirNome(String texto, int tamanho) {
        String nome;
        String meio = new String();
        String sobrenome = new String();

        // Sanitiza o texto
        texto = texto.trim();
        // FIX: java.lang.StringIndexOutOfBoundsException: String index out of range: 0
        // at java.lang.String.charAt(String.java:695)
        // at info.netinho.util.Text.reduzirNome(Text.java:205)
        while (texto.contains("  ")) {
            texto = texto.replaceAll("  ", " ");
        }

        // Se o nome for maior que o permitido
        if (texto.length() > (tamanho - 2)) {
            // $texto = strip_tags($texto);

            // Pego o primeiro nome
            String[] palavras = texto.split(" ");
            nome = palavras[0];

            // Pego o ultimo nome
            // $palavas = explode(' ', $texto);
            sobrenome = palavras[palavras.length - 1];

            // Vejo qual e a posicao do ultimo nome
            int ult_posicao = palavras.length - 1;

            // Crio uma variavel para receber os nomes do meio abreviados
            // $meio = '';
            // Listo todos os nomes do meios e abrevio eles
            for (int a = 1; a < ult_posicao; a++) {
                // Enquanto o tamanho do nome nao atingir o limite de caracteres
                // completo com o nomes do meio abreviado
                if ((nome + " " + meio + " " + sobrenome).length() <= tamanho) {
                    String letra = "" + palavras[a].charAt(0);
                    meio += " " + letra.toUpperCase() + ".";

                    // preenche uma variavel com a quantidade de termos restantes
                    String restante = new String();
                    for (int b = a + 1; b < ult_posicao; b++) {
                        restante += " " + palavras[b];
                    }

                    // verifica se dessa forma ja conseguiu abreviar o suficiente
                    if ((nome + " " + meio + restante + " " + sobrenome).length() <= tamanho) {
                        meio = meio + restante;
                        break;
                    }
                }
            }
        } else {
            nome = texto;
        }

        return (nome + meio + " " + sobrenome).trim();
    }

    public static boolean validateStrongPassword(String password) {
        // (/^
        // (?=.*\d)                //should contain at least one digit
        // (?=.*[a-z])             //should contain at least one lower case
        // (?=.*[A-Z])             //should contain at least one upper case
        // [a-zA-Z0-9]{5,}         //should contain at least 5 from the mentioned characters
        // $/)
        // /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])([a-zA-Z0-9]{8,})$/
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])([a-zA-Z0-9]{5,})$");
    }

    /**
     * Gera uma senha randômica e que atende aos critérios mínimos de segurança.
     *
     * @return Senha randômica
     */
    public static String generatePassword() {
        String generatedPassword = RandomStringUtils.random(12, true, true);
        while (!validateStrongPassword(generatedPassword)) {
            generatedPassword = RandomStringUtils.random(12, true, true);
        }

        return generatedPassword;
    }

}
