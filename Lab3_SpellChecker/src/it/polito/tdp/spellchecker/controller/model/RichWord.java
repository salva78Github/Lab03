package it.polito.tdp.spellchecker.controller.model;

public class RichWord {
	private final String word;
	private boolean isCorrect;

	public RichWord(String word) {
		this.word = word;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}


	public String getWord() {
		return word;
	}
	
	@Override
	public String toString() {
		return "RichWord [word=" + word + ", isCorrect=" + isCorrect + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RichWord other = (RichWord) obj;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}


}
