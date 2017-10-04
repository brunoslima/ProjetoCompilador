/* The following code was generated by JFlex 1.6.1 */

package lexico;
import static lexico.Simbolo.*;



/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>src/lexico/Lexer.flex</tt>
 */
public class Lexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\2\1\7\1\54\1\54\1\3\22\0\1\1\7\0\1\46"+
    "\1\47\1\45\1\43\1\35\1\44\1\36\1\6\12\50\1\33\1\34"+
    "\1\41\1\40\1\42\2\0\32\53\4\0\1\51\1\0\1\14\1\16"+
    "\1\23\1\22\1\17\1\30\1\13\1\37\1\20\2\53\1\27\1\15"+
    "\1\21\1\12\1\10\1\53\1\11\1\31\1\26\1\24\1\25\1\32"+
    "\3\53\1\4\1\52\1\5\7\0\1\54\u1fa2\0\1\54\1\54\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\udfe6\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\1\16\6"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\1\22\1\23\1\4\1\5\1\0"+
    "\2\6\1\24\6\6\1\25\1\6\1\26\7\6\1\27"+
    "\1\30\1\31\1\32\1\0\1\23\1\33\2\6\1\34"+
    "\2\6\1\35\1\6\1\36\1\37\1\40\1\41\5\6"+
    "\1\42\1\23\2\6\1\43\1\44\2\6\1\45\1\46"+
    "\1\47\3\6\1\42\1\23\3\6\1\50\1\51\1\52"+
    "\1\53\1\42\1\23\3\6\1\42\1\23\1\54\1\6"+
    "\1\55\1\42\1\23\1\6\1\42\1\23\1\56\2\23"+
    "\1\0";

  private static int [] zzUnpackAction() {
    int [] result = new int[121];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\55\0\55\0\55\0\55\0\132\0\207\0\264"+
    "\0\341\0\u010e\0\u013b\0\u0168\0\u0195\0\u01c2\0\u01ef\0\u021c"+
    "\0\u0249\0\u0276\0\u02a3\0\u02d0\0\u02fd\0\u032a\0\55\0\55"+
    "\0\55\0\55\0\u0357\0\u0384\0\55\0\55\0\55\0\55"+
    "\0\55\0\u03b1\0\u013b\0\55\0\u03de\0\u040b\0\u0438\0\u013b"+
    "\0\u0465\0\u0492\0\u04bf\0\u04ec\0\u0519\0\u0546\0\u013b\0\u0573"+
    "\0\u013b\0\u05a0\0\u05cd\0\u05fa\0\u0627\0\u0654\0\u0681\0\u06ae"+
    "\0\55\0\55\0\55\0\55\0\u06db\0\u0708\0\55\0\u0735"+
    "\0\u0762\0\u013b\0\u078f\0\u07bc\0\u013b\0\u07e9\0\u013b\0\u013b"+
    "\0\u013b\0\u013b\0\u0816\0\u0843\0\u0870\0\u089d\0\u08ca\0\u08f7"+
    "\0\u0924\0\u0951\0\u097e\0\u013b\0\u013b\0\u09ab\0\u09d8\0\u013b"+
    "\0\u013b\0\u013b\0\u0a05\0\u0a32\0\u0a5f\0\u0a8c\0\u0ab9\0\u0ae6"+
    "\0\u0b13\0\u0b40\0\u013b\0\u013b\0\u013b\0\u013b\0\u0b6d\0\u0b9a"+
    "\0\u0bc7\0\u0bf4\0\u0c21\0\u0c4e\0\u0c7b\0\u013b\0\u0ca8\0\u013b"+
    "\0\u0cd5\0\u0d02\0\u0d2f\0\55\0\u0d5c\0\u013b\0\u0d89\0\u0db6"+
    "\0\u0db6";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[121];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\2\1\7\1\5"+
    "\1\10\1\11\1\12\1\13\1\14\1\13\1\15\1\16"+
    "\1\17\1\20\1\21\2\13\1\22\1\23\1\13\1\24"+
    "\1\13\1\25\1\26\1\27\1\30\1\31\1\13\1\32"+
    "\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42"+
    "\1\13\1\43\1\13\56\0\5\6\1\44\47\6\6\0"+
    "\1\45\56\0\1\13\1\46\21\13\4\0\1\13\10\0"+
    "\1\13\1\0\2\13\11\0\7\13\1\47\13\13\4\0"+
    "\1\13\10\0\1\13\1\0\2\13\11\0\1\13\1\50"+
    "\21\13\4\0\1\13\10\0\1\13\1\0\2\13\11\0"+
    "\23\13\4\0\1\13\10\0\1\13\1\0\2\13\11\0"+
    "\11\13\1\51\11\13\4\0\1\13\10\0\1\13\1\0"+
    "\2\13\11\0\2\13\1\52\4\13\1\53\13\13\4\0"+
    "\1\13\10\0\1\13\1\0\2\13\11\0\11\13\1\54"+
    "\5\13\1\55\3\13\4\0\1\13\10\0\1\13\1\0"+
    "\2\13\11\0\11\13\1\56\6\13\1\57\2\13\4\0"+
    "\1\13\10\0\1\13\1\0\2\13\11\0\2\13\1\60"+
    "\20\13\4\0\1\13\10\0\1\13\1\0\2\13\11\0"+
    "\2\13\1\61\5\13\1\62\12\13\4\0\1\13\10\0"+
    "\1\13\1\0\2\13\11\0\4\13\1\63\16\13\4\0"+
    "\1\13\10\0\1\13\1\0\2\13\11\0\1\13\1\64"+
    "\21\13\4\0\1\65\10\0\1\13\1\0\2\13\11\0"+
    "\4\13\1\66\16\13\4\0\1\13\10\0\1\13\1\0"+
    "\2\13\11\0\1\13\1\67\21\13\4\0\1\70\10\0"+
    "\1\13\1\0\2\13\41\0\1\71\54\0\1\72\1\0"+
    "\1\73\52\0\1\74\52\0\1\75\11\0\1\76\4\0"+
    "\7\45\1\77\45\45\10\0\2\13\1\100\20\13\4\0"+
    "\1\13\10\0\1\13\1\0\2\13\11\0\4\13\1\101"+
    "\16\13\4\0\1\13\10\0\1\13\1\0\2\13\11\0"+
    "\12\13\1\102\10\13\4\0\1\13\10\0\1\13\1\0"+
    "\2\13\11\0\2\13\1\103\20\13\4\0\1\13\10\0"+
    "\1\13\1\0\2\13\11\0\3\13\1\104\17\13\4\0"+
    "\1\13\10\0\1\13\1\0\2\13\11\0\12\13\1\105"+
    "\10\13\4\0\1\13\10\0\1\13\1\0\2\13\11\0"+
    "\21\13\1\106\1\13\4\0\1\13\10\0\1\13\1\0"+
    "\2\13\11\0\16\13\1\107\4\13\4\0\1\13\10\0"+
    "\1\13\1\0\2\13\11\0\16\13\1\110\4\13\4\0"+
    "\1\13\10\0\1\13\1\0\2\13\11\0\15\13\1\111"+
    "\5\13\4\0\1\13\10\0\1\13\1\0\2\13\11\0"+
    "\1\13\1\112\21\13\4\0\1\13\10\0\1\13\1\0"+
    "\2\13\11\0\14\13\1\113\6\13\4\0\1\13\10\0"+
    "\1\13\1\0\2\13\11\0\7\13\1\114\13\13\4\0"+
    "\1\13\10\0\1\13\1\0\2\13\11\0\17\13\1\115"+
    "\3\13\4\0\1\13\10\0\1\13\1\0\2\13\11\0"+
    "\10\13\1\116\12\13\4\0\1\13\10\0\1\13\1\0"+
    "\2\13\11\0\10\13\1\117\12\13\4\0\1\13\10\0"+
    "\1\13\1\0\2\13\51\0\1\120\42\0\1\75\11\0"+
    "\1\121\14\0\3\13\1\122\7\13\1\123\7\13\4\0"+
    "\1\13\10\0\1\13\1\0\2\13\11\0\12\13\1\124"+
    "\4\13\1\125\3\13\4\0\1\13\10\0\1\13\1\0"+
    "\2\13\11\0\17\13\1\126\3\13\4\0\1\13\10\0"+
    "\1\13\1\0\2\13\11\0\10\13\1\127\12\13\4\0"+
    "\1\13\10\0\1\13\1\0\2\13\11\0\7\13\1\130"+
    "\13\13\4\0\1\13\10\0\1\13\1\0\2\13\11\0"+
    "\7\13\1\131\13\13\4\0\1\13\10\0\1\13\1\0"+
    "\2\13\11\0\11\13\1\132\11\13\4\0\1\13\10\0"+
    "\1\13\1\0\2\13\11\0\21\13\1\133\1\13\4\0"+
    "\1\13\10\0\1\13\1\0\2\13\11\0\16\13\1\134"+
    "\4\13\4\0\1\13\10\0\1\13\1\0\2\13\11\0"+
    "\17\13\1\135\3\13\4\0\1\13\10\0\1\13\1\0"+
    "\2\13\51\0\1\136\42\0\1\75\11\0\1\137\14\0"+
    "\1\13\1\140\21\13\4\0\1\13\10\0\1\13\1\0"+
    "\2\13\11\0\7\13\1\141\13\13\4\0\1\13\10\0"+
    "\1\13\1\0\2\13\11\0\7\13\1\142\13\13\4\0"+
    "\1\13\10\0\1\13\1\0\2\13\11\0\11\13\1\143"+
    "\11\13\4\0\1\13\10\0\1\13\1\0\2\13\11\0"+
    "\7\13\1\144\13\13\4\0\1\13\10\0\1\13\1\0"+
    "\2\13\11\0\7\13\1\145\13\13\4\0\1\13\10\0"+
    "\1\13\1\0\2\13\11\0\7\13\1\146\13\13\4\0"+
    "\1\13\10\0\1\13\1\0\2\13\51\0\1\147\42\0"+
    "\1\75\11\0\1\150\14\0\4\13\1\151\16\13\4\0"+
    "\1\13\10\0\1\13\1\0\2\13\11\0\12\13\1\152"+
    "\10\13\4\0\1\13\10\0\1\13\1\0\2\13\11\0"+
    "\4\13\1\153\16\13\4\0\1\13\10\0\1\13\1\0"+
    "\2\13\51\0\1\154\42\0\1\75\11\0\1\155\14\0"+
    "\5\13\1\156\15\13\4\0\1\13\10\0\1\13\1\0"+
    "\2\13\11\0\14\13\1\157\6\13\4\0\1\13\10\0"+
    "\1\13\1\0\2\13\11\0\11\13\1\160\11\13\4\0"+
    "\1\13\10\0\1\13\1\0\2\13\51\0\1\161\42\0"+
    "\1\75\11\0\1\162\14\0\1\13\1\163\21\13\4\0"+
    "\1\13\10\0\1\13\1\0\2\13\51\0\1\164\42\0"+
    "\1\75\11\0\1\165\14\0\7\13\1\166\13\13\4\0"+
    "\1\13\10\0\1\13\1\0\2\13\37\0\1\75\11\0"+
    "\1\167\42\0\1\75\11\0\1\170\42\0\1\75\11\0"+
    "\1\171\4\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3555];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\4\11\21\1\4\11\2\1\5\11\2\1\1\11"+
    "\1\0\23\1\4\11\1\0\1\1\1\11\64\1\1\11"+
    "\4\1\1\0";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[121];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */



private Item add(Simbolo descricao, String lexema) {
    
    Item item = new Item(lexema, descricao, yyline, yycolumn, yycolumn + lexema.length()-1 );
    
    item.setOffset(yychar);
    return item;
}



  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 152) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Item yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return add(ERROR, yytext());
            }
          case 47: break;
          case 2: 
            { return add(ESPACO, yytext());
            }
          case 48: break;
          case 3: 
            { return add(TAB, yytext());
            }
          case 49: break;
          case 4: 
            { AnalisadorLexico.linha++; AnalisadorLexico.coluna = 0; return add(NOVA_LINHA, yytext());
            }
          case 50: break;
          case 5: 
            { return add(COMENTARIO_MULTI, yytext());
            }
          case 51: break;
          case 6: 
            { return add(IDENTIFICADOR, yytext());
            }
          case 52: break;
          case 7: 
            { return add(SIMBOLO_DOIS_PONTOS, yytext());
            }
          case 53: break;
          case 8: 
            { return add(SIMBOLO_PONTO_VIRGULA, yytext());
            }
          case 54: break;
          case 9: 
            { return add(SIMBOLO_VIRGULA, yytext());
            }
          case 55: break;
          case 10: 
            { return add(SIMBOLO_PONTO, yytext());
            }
          case 56: break;
          case 11: 
            { return add(SIMBOLO_IGUAL, yytext());
            }
          case 57: break;
          case 12: 
            { return add(SIMBOLO_MENOR, yytext());
            }
          case 58: break;
          case 13: 
            { return add(SIMBOLO_MAIOR, yytext());
            }
          case 59: break;
          case 14: 
            { return add(OPERADOR_ADICAO, yytext());
            }
          case 60: break;
          case 15: 
            { return add(OPERADOR_SUBTRACAO, yytext());
            }
          case 61: break;
          case 16: 
            { return add(OPERADOR_MULTIPLICACAO, yytext());
            }
          case 62: break;
          case 17: 
            { return add(PARENTESES_ABRE, yytext());
            }
          case 63: break;
          case 18: 
            { return add(PARENTESES_FECHA, yytext());
            }
          case 64: break;
          case 19: 
            { return add(NUMERO_INTEIRO, yytext());
            }
          case 65: break;
          case 20: 
            { return add(OPERADOR_OR, yytext());
            }
          case 66: break;
          case 21: 
            { return add(PALAVRA_RESERVADA_IF, yytext());
            }
          case 67: break;
          case 22: 
            { return add(PALAVRA_RESERVADA_DO, yytext());
            }
          case 68: break;
          case 23: 
            { return add(OPERADOR_ATRIBUICAO, yytext());
            }
          case 69: break;
          case 24: 
            { return add(SIMBOLO_MENOR_IGUAL, yytext());
            }
          case 70: break;
          case 25: 
            { return add(SIMBOLO_DIFERENTE, yytext());
            }
          case 71: break;
          case 26: 
            { return add(SIMBOLO_MAIOR_IGUAL, yytext());
            }
          case 72: break;
          case 27: 
            { AnalisadorLexico.linha++; AnalisadorLexico.coluna = 0; return add(COMENTARIO_LINHA, yytext());
            }
          case 73: break;
          case 28: 
            { return add(OPERADOR_AND, yytext());
            }
          case 74: break;
          case 29: 
            { return add(PALAVRA_RESERVADA_END, yytext());
            }
          case 75: break;
          case 30: 
            { return add(PALAVRA_RESERVADA_INT, yytext());
            }
          case 76: break;
          case 31: 
            { return add(OPERADOR_NOT, yytext());
            }
          case 77: break;
          case 32: 
            { return add(OPERADOR_DIVISAO, yytext());
            }
          case 78: break;
          case 33: 
            { return add(PALAVRA_RESERVADA_VAR, yytext());
            }
          case 79: break;
          case 34: 
            { return add(NUMERO_REAL, yytext());
            }
          case 80: break;
          case 35: 
            { return add(PALAVRA_RESERVADA_READ, yytext());
            }
          case 81: break;
          case 36: 
            { return add(PALAVRA_RESERVADA_REAL, yytext());
            }
          case 82: break;
          case 37: 
            { return add(PALAVRA_RESERVADA_ELSE, yytext());
            }
          case 83: break;
          case 38: 
            { return add(VALOR_LOGICO_TRUE, yytext());
            }
          case 84: break;
          case 39: 
            { return add(PALAVRA_RESERVADA_THEN, yytext());
            }
          case 85: break;
          case 40: 
            { return add(PALAVRA_RESERVADA_BEGIN, yytext());
            }
          case 86: break;
          case 41: 
            { return add(VALOR_LOGICO_FALSE, yytext());
            }
          case 87: break;
          case 42: 
            { return add(PALAVRA_RESERVADA_WRITE, yytext());
            }
          case 88: break;
          case 43: 
            { return add(PALAVRA_RESERVADA_WHILE, yytext());
            }
          case 89: break;
          case 44: 
            { return add(PALAVRA_RESERVADA_PROGRAM, yytext());
            }
          case 90: break;
          case 45: 
            { return add(PALAVRA_RESERVADA_BOOLEAN, yytext());
            }
          case 91: break;
          case 46: 
            { return add(PALAVRA_RESERVADA_PROCEDURE, yytext());
            }
          case 92: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
