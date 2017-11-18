/*
    ============================================
    =                                          =
    =             DCrypt by Dmnd098            =
    =             ver = prototype 1            =
    =        github.com/Diamondcreeper098      =
    =          email: dmnd098@gmail.com        =
    =                                          =
    ============================================
 */


//Notice : My Encrypting algorithm is an prototype thing and this algorithm don't work with files

package Dmnd098.DCrypt;

public class DCrypt {
    int slt = 4;
    String md = "";
    public DCrypt(int salt, String mode) //initializing class
    {
        slt = salt;
        md = mode;
    }
    public DCrypt(String mode)
    {
        md = mode;
    }
    public String Encrypt(String txt) {
        String r = "";
        char[] tmp = txt.toCharArray(); // Making a array of characters for text
        if (md == "Sum"){
            for (char s : tmp) {
                int f = (int)s + slt;


                r += Character.toString((char)f); // just summing current char with salt
                if (r == ""){
                    throw new RuntimeException("Cannot Encrypt"); // if result remain empty then throw an exception with message of "Cannot Encrypt"
                }
            }
                
        }
        if (md == "Minus"){
            for (char s : tmp) {
                int f = (int)s - slt;


                r += Character.toString((char)f); // just Minus current char with salt
                if (r == ""){
                    throw new RuntimeException("Cannot Encrypt");// if result remain empty then throw an exception with message of "Cannot Encrypt"
                }
            }

        }
        return r;
    }
    public String Decrypt(String txt)
    {
        String r = "";
        char[] tmp = txt.toCharArray();
        if (md == "Sum"){
            for (char s : tmp) {
                int f = (int)s - slt;


                r += Character.toString((char)f); // just Minus current char with salt
                if (r == ""){
                    throw new RuntimeException("Cannot Decrypt");
                }
            }

        }
        if (md == "Minus"){
            for (char s : tmp) {
                int f = (int)s + slt;


                r += Character.toString((char)f); // just summing current char with salt
                if (r == ""){
                    throw new RuntimeException("Cannot Decrypt");
                }
            }

        }
        return r;
    }
}
