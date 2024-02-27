public class DNARNA {
    /*
    Write a program that given a String representation of a DNA sequence and returns its transcribed RNA
sequence. The main differences that distinguish DNA from RNA is that RNA contains the sugar ribose,
while DNA contains the slightly different sugar deoxyribose (a type of ribose that lacks one oxygen
atom),
Constraints
• All characters in the DNA sequences ∈ {‘A’, ‘C’, ‘G’, ‘T’}
Output Format
For each String, return (and print to console) the corresponding RNA sequence
Sample Input
AGCTGGGAAACGTAGGCCTA
Sample Output
AGCUGGGAAACGUAGGCCUA
     */
    public static String transcribeToRna(String dnaSequence) {
        StringBuilder rnaSequence = new StringBuilder();

        for (char nucleotide : dnaSequence.toCharArray()) {
            switch (nucleotide) {
                case 'A':
                    //rnaSequence+='A';
                    rnaSequence.append('A');
                    break;
                case 'C':
                    //rnaSequence+='C';
                    rnaSequence.append('C');
                    break;
                case 'G':
                    //rnaSequence+='G';
                    rnaSequence.append('G');
                    break;
                case 'T':
                    //rnaSequence+='U';
                    rnaSequence.append('U');
                    break;
                default:
                    // if characters not allowed
                    break;
            }
        }

        return rnaSequence.toString();
    }

    public static void main(String[] args) {
        // examples
        String dna1 = "AGCTGGGAAACGTAGGCCTA";
        String dna2 = "TTTTTTTTTTGGCGCG";
        String dna3 = "CTTTGGGACTAGTAACCCATTTCGGCT";

        //print the result
        System.out.println(transcribeToRna(dna1));  // output: AGCUGGGAAACGUAGGCCUA
        System.out.println(transcribeToRna(dna2));  // output: UUUUUUUUUUGGCGCG
        System.out.println(transcribeToRna(dna3));  // output: CUUUGGGACUAGUAACCCAUUUCGGCU
    }

}
