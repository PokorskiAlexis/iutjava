package edu.iut.app;

// TODO: Auto-generated Javadoc
/**
 * La Classe CommandLineOption.
 *
 * @param <ValueType> Un Type Générique
 */
public class CommandLineOption <ValueType> {
	
	/**
	 * L'énumeration d'OptionType.
	 */
	public enum OptionType{
		
		/** Rien */
		NONE("None"),
		
		/** Le fichier. */
		FILE("File"),
		
		/** La chaine de caractère. */
		STRING("String"),
		
		/** L'entier. */
		INTEGER("Integer"),
		
		/** Le double. */
		DOUBLE("Double"),
		
		/** Le Sans valeur. */
		NOVALUE("NoValue");
		
		/** Les type d'option. */
		private String optionType;
		
		/**
		 * Crée un nouvelle option type.
		 *
		 * @param optionType la nouvelle option
		 */
		OptionType(String optionType) {
			this.optionType = optionType;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Enum#toString()
		 */
		public String toString() {
			return optionType;
		}		
	}
	
	/**
	 * Crée une nouvelle command line option.
	 */
	public CommandLineOption() {		
		/* EX1: Initializer les attributs */
		this.value= null;
		this.key = null;
		this.description = null;
		this.defaultValue=null;
		this.optionType=null;
	}
	
	/**
	 * Crée une nouvelle command line option.
	 *
	 * @param optionType l'option type
	 * @param key la clé
	 * @param description une description
	 * @param defaultValue la Valeur par defaut
	 */
	public CommandLineOption(final OptionType optionType, final String key, final String description, final ValueType defaultValue) {
		/* EX1 : Affecter les attributs */
		this.value= null;
		this.key = key;
		this.description = description;
		this.defaultValue=defaultValue;
		this.optionType=optionType;
	}
	
	/**
	 * Ajouter une option.
	 *
	 * @param optionType l'option type
	 * @param key la clé
	 * @param description une description
	 * @param defaultValue la Valeur par defaut
	 */
	public void setOption(OptionType optionType, String key, String description, ValueType defaultValue) {
		/* EX1 : Affecter les attributs */
		this.value= null;
		this.key = key;
		this.description = description;
		this.defaultValue=defaultValue;
		this.optionType=optionType;
	}
	
	/**
	 * Modifier la valeur
	 *
	 * @param value la nouvelle valeur
	 */
	public  void setValue(ValueType value) {
		this.value = value;
	}
		
	/**
	 * Obtenir la clé.
	 *
	 * @return La clé
	 */
	public String getKey() {
		return this.key;
	}
	
	/**
	 * Obtenir la description.
	 *
	 * @return la description
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * Obtenir la valeur.
	 *
	 * @return la valeur
	 */
	public ValueType getValue() {
		if (value != null) {
			return value;
		}
		return defaultValue;
	}
	
	/**
	 * Obtenir le type d'option.
	 *
	 * @return le type d'option
	 */
	public OptionType getOptionType() {
		return optionType;
	}

	/** La key. */
	protected String key;
	
	/** La description. */
	protected String description;
	
	/** La valeur par défaut. */
	protected ValueType defaultValue;
	
	/** La Valeur. */
	protected ValueType value;
	
	/** Le type d'option. */
	protected OptionType optionType;
	

}
