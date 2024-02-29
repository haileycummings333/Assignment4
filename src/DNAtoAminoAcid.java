import java.util.HashMap;

public class DNAtoAminoAcid {
    /*After RNA strands are created from DNA strands after transcription, the genetic information in the RNA
    sequence about a protein sequence to the ribosomes, the protein synthesis factories in the cell. It is coded
    so that every three nucleotides(codon) correspond to one amino acid (See Figure 2.)
    Constraints
    • All characters in the DNA sequences ∈ {‘A’, ‘C’, ‘G’, ‘U’}
    • The output should use the single letter representation for each amino acid as seen in the wheel
    rather than the three-letter representation seen in the table
    • The codons {UAA, UAG, UGA} will map to a single period (.)
    • If the length of the input is not a multiple of three, end the amino acid sequence with a (.)
    Output Format
    For each String, return (print to console) the corresponding sequence of amino acids
    Sample Input
    AGCUGGGAAACGUAGGCCUA
    Sample Output
    SWET.A.
    Sample Input
    UAAAGAGAAGCCAGC
    Sample Output
    .GREAT

     */

    private static final HashMap<String, Character> proteins = new HashMap<>();

    static {
        proteins.put("UUU", 'F');
        proteins.put("UUC", 'F');
        proteins.put("UUA", 'L');
        proteins.put("UUG", 'L');
        proteins.put("CUU", 'L');
        proteins.put("CUC", 'L');
        proteins.put("CUA", 'L');
        proteins.put("CUG", 'L');
        proteins.put("AUU", 'I');
        proteins.put("AUC", 'I');
        proteins.put("AUA", 'I');
        proteins.put("AUG", 'M');
        proteins.put("GUU", 'V');
        proteins.put("GUC", 'V');
        proteins.put("GUA", 'V');
        proteins.put("GUG", 'V');
        proteins.put("UCU", 'S');
        proteins.put("UCC", 'S');
        proteins.put("UCA", 'S');
        proteins.put("UCG", 'S');
        proteins.put("CCU", 'P');
        proteins.put("CCC", 'P');
        proteins.put("CCA", 'P');
        proteins.put("CCG", 'P');
        proteins.put("ACU", 'T');
        proteins.put("ACC", 'T');
        proteins.put("ACA", 'T');
        proteins.put("ACG", 'T');
        proteins.put("GCU", 'A');
        proteins.put("GCC", 'A');
        proteins.put("GCA", 'A');
        proteins.put("GCG", 'A');
        proteins.put("UAU", 'Y');
        proteins.put("UAC", 'Y');
        proteins.put("UAA", '.');
        proteins.put("UAG", '.');
        proteins.put("UGA", '.');
        proteins.put("CAU", 'H');
        proteins.put("CAC", 'H');
        proteins.put("CAA", 'Q');
        proteins.put("CAG", 'Q');
        proteins.put("AAU", 'N');
        proteins.put("AAC", 'N');
        proteins.put("AAA", 'K');
        proteins.put("AAG", 'K');
        proteins.put("GAU", 'D');
        proteins.put("GAC", 'D');
        proteins.put("GAA", 'E');
        proteins.put("GAG", 'E');
        proteins.put("UGU", 'C');
        proteins.put("UGC", 'C');
        proteins.put("UGG", 'W');
        proteins.put("CGU", 'R');
        proteins.put("CGC", 'R');
        proteins.put("CGA", 'R');
        proteins.put("CGG", 'R');
        proteins.put("AGU", 'S');
        proteins.put("AGC", 'S');
        proteins.put("AGA", 'R');
        proteins.put("AGG", 'R');
        proteins.put("GGU", 'G');
        proteins.put("GGC", 'G');
        proteins.put("GGA", 'G');
        proteins.put("GGG", 'G');
    }


    private static String rnaToAminoAcid(String rnaSequence) {
        StringBuilder result = new StringBuilder();

        //loop over sequence with step size of 3 bc each codon is 3 nucleotides
        for (int i = 0; i < rnaSequence.length(); i += 3) {
            // extract codon, Math.min(i + 3, rnaSequence.length() makes sure it doesn't exceed length of seq.
            // used StackOverflow for the Math.min part
            String codon = rnaSequence.substring(i, Math.min(i + 3, rnaSequence.length()));

            // map codon to amino acid and append to result, if can't find codon, append .
            result.append(proteins.getOrDefault(codon, '.'));
        }
        return result.toString();
    }


    public static void main(String[] args) {
        String rna1 = "AGCUGGGAAACGUAGGCCUA";
        String rna2 = "UAAAGAGAAGCCAGC";

        // translate to amino acids
        String aminoAcids1 = rnaToAminoAcid(rna1);
        String aminoAcids2 = rnaToAminoAcid(rna2);

        System.out.println(aminoAcids1); // Output: SWET.A.
        System.out.println(aminoAcids2); // Output: .GREAT
    }
}
