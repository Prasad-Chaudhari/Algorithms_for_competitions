import java.util.*;
class sol {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        char [] vowels={'a','e','i','o','u'};
        char [] consonants={'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','z'};
        if(n==1){
            for(char a:vowels){
                System.out.println(a);
            }
            for(char a:consonants){
                System.out.println(a);
            }
        }
        if(n==2){
            for(char a:vowels){
                for(char b:consonants){
                    System.out.println(a+""+b);
                }
            }
            for(char a:consonants){
                for(char b:vowels){
                    System.out.println(a+""+b);
                }
            }
        }
        if(n==3){
            for(char a:vowels){
                for(char b:consonants){
                    for(char c:vowels){
                        System.out.println(a+""+b+""+c);
                    }
                }
            }
            for(char a:consonants){
                for(char b:vowels){
                    for(char c:consonants){
                        System.out.println(a+""+b+""+c);                        
                    }
                }
            }
        }
        if(n==4){
            for(char a:vowels){
                for(char b:consonants){
                    for(char c:vowels){
                        for(char d:consonants){
                            System.out.println(a+""+b+""+c+""+d);                            
                        }
                    }
                }
            }
            for(char a:consonants){
                for(char b:vowels){
                    for(char c:consonants){
                        for(char d:vowels){
                            System.out.println(a+""+b+""+c+""+d);                            
                        }
                    }
                }
            }
        }
        if(n==5){
            for(char a:vowels){
                for(char b:consonants){
                    for(char c:vowels){
                        for(char d:consonants){
                            for(char e:vowels){
                                System.out.println(a+""+b+""+c+""+d+""+e);
                            }
                        }
                    }
                }
            }
            for(char a:consonants){
                for(char b:vowels){
                    for(char c:consonants){
                        for(char d:vowels){
                            for(char e:consonants){
                                System.out.println(a+""+b+""+c+""+d+""+e);
                            }
                        }
                    }
                }
            }
        }
        if(n==6){
            for(char a:vowels){
                for(char b:consonants){
                    for(char c:vowels){
                        for(char d:consonants){
                            for(char e:vowels){
                                for(char f:consonants){
                                    System.out.println(a+""+b+""+c+""+d+""+e+""+f);
                                }
                            }
                        }
                    }
                }
            }
            for(char a:consonants){
                for(char b:vowels){
                    for(char c:consonants){
                        for(char d:vowels){
                            for(char e:consonants){
                                for(char f:vowels){
                                    System.out.println(a+""+b+""+c+""+d+""+e+""+f);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}   