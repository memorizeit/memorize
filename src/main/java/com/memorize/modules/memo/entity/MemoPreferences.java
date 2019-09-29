package com.memorize.modules.memo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MemoPreferences implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String name;

	@Column(name = "background_color", nullable = false)
	private int backgroundColor;

	@Column(name = "night_mode", columnDefinition = "boolean default false")
	private boolean nightMode;

	@Column(name = "font_size", nullable = false)
	private int fontSize;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private MemoVisibility visibility;

	@OneToMany(mappedBy = "preferences")
	private List<Memo> memos;

	public MemoPreferences() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(int backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public boolean isNightMode() {
		return nightMode;
	}

	public void setNightMode(boolean nightMode) {
		this.nightMode = nightMode;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public MemoVisibility getVisibility() {
		return visibility;
	}

	public void setVisibility(MemoVisibility visibility) {
		this.visibility = visibility;
	}

	public List<Memo> getMemos() {
		return memos;
	}

	public void setMemos(List<Memo> memos) {
		this.memos = memos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + backgroundColor;
		result = prime * result + fontSize;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (nightMode ? 1231 : 1237);
		result = prime * result + ((visibility == null) ? 0 : visibility.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		MemoPreferences other = (MemoPreferences) obj;
		if (backgroundColor != other.backgroundColor) {
			return false;
		}
		if (fontSize != other.fontSize) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (nightMode != other.nightMode) {
			return false;
		}
		if (visibility != other.visibility) {
			return false;
		}
		return true;
	}
}
