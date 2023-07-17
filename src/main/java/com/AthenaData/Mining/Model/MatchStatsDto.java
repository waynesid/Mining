package com.AthenaData.Mining.Model;

import java.util.Date;

/**
 * @author wayne
 * @Date 17/07/2023
 */
public class MatchStatsDto {
    private String league;
    private String year;
    private String h_a;
    private float xg;
    private float xGa;
    private float npxG;
    private float deep;
    private float deep_allowed;
    private float scored;
    private float missed;
    private float xpts;
    private String result;
    private Date date;
    private float wins;
    private float draws;
    private float loses;
    private float pts;
    private float npxGD;
    private float ppda_coef;
    private float ppda_att;
    private float ppda_def;
    private float oppda_coef;
    private float oppda_att;
    private float oppda_def;
    private String team;
    private float xG_diff;
    private float xGA_diff;
    private float xpts_diff;

    public MatchStatsDto() {
    }

    public MatchStatsDto(String league, String year, String h_a, float xg, float xGa, float npxG, float deep, float deep_allowed, float scored, float missed, float xpts, String result, Date date, float wins, float draws, float loses, float pts, float npxGD, float ppda_coef, float ppda_att, float ppda_def, float oppda_coef, float oppda_att, float oppda_def, String team, float xG_diff, float xGA_diff, float xpts_diff) {
        this.league = league;
        this.year = year;
        this.h_a = h_a;
        this.xg = xg;
        this.xGa = xGa;
        this.npxG = npxG;
        this.deep = deep;
        this.deep_allowed = deep_allowed;
        this.scored = scored;
        this.missed = missed;
        this.xpts = xpts;
        this.result = result;
        this.date = date;
        this.wins = wins;
        this.draws = draws;
        this.loses = loses;
        this.pts = pts;
        this.npxGD = npxGD;
        this.ppda_coef = ppda_coef;
        this.ppda_att = ppda_att;
        this.ppda_def = ppda_def;
        this.oppda_coef = oppda_coef;
        this.oppda_att = oppda_att;
        this.oppda_def = oppda_def;
        this.team = team;
        this.xG_diff = xG_diff;
        this.xGA_diff = xGA_diff;
        this.xpts_diff = xpts_diff;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getH_a() {
        return h_a;
    }

    public void setH_a(String h_a) {
        this.h_a = h_a;
    }

    public float getXg() {
        return xg;
    }

    public void setXg(float xg) {
        this.xg = xg;
    }

    public float getxGa() {
        return xGa;
    }

    public void setxGa(float xGa) {
        this.xGa = xGa;
    }

    public float getNpxG() {
        return npxG;
    }

    public void setNpxG(float npxG) {
        this.npxG = npxG;
    }

    public float getDeep() {
        return deep;
    }

    public void setDeep(float deep) {
        this.deep = deep;
    }

    public float getDeep_allowed() {
        return deep_allowed;
    }

    public void setDeep_allowed(float deep_allowed) {
        this.deep_allowed = deep_allowed;
    }

    public float getScored() {
        return scored;
    }

    public void setScored(float scored) {
        this.scored = scored;
    }

    public float getMissed() {
        return missed;
    }

    public void setMissed(float missed) {
        this.missed = missed;
    }

    public float getXpts() {
        return xpts;
    }

    public void setXpts(float xpts) {
        this.xpts = xpts;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getWins() {
        return wins;
    }

    public void setWins(float wins) {
        this.wins = wins;
    }

    public float getDraws() {
        return draws;
    }

    public void setDraws(float draws) {
        this.draws = draws;
    }

    public float getLoses() {
        return loses;
    }

    public void setLoses(float loses) {
        this.loses = loses;
    }

    public float getPts() {
        return pts;
    }

    public void setPts(float pts) {
        this.pts = pts;
    }

    public float getNpxGD() {
        return npxGD;
    }

    public void setNpxGD(float npxGD) {
        this.npxGD = npxGD;
    }

    public float getPpda_coef() {
        return ppda_coef;
    }

    public void setPpda_coef(float ppda_coef) {
        this.ppda_coef = ppda_coef;
    }

    public float getPpda_att() {
        return ppda_att;
    }

    public void setPpda_att(float ppda_att) {
        this.ppda_att = ppda_att;
    }

    public float getPpda_def() {
        return ppda_def;
    }

    public void setPpda_def(float ppda_def) {
        this.ppda_def = ppda_def;
    }

    public float getOppda_coef() {
        return oppda_coef;
    }

    public void setOppda_coef(float oppda_coef) {
        this.oppda_coef = oppda_coef;
    }

    public float getOppda_att() {
        return oppda_att;
    }

    public void setOppda_att(float oppda_att) {
        this.oppda_att = oppda_att;
    }

    public float getOppda_def() {
        return oppda_def;
    }

    public void setOppda_def(float oppda_def) {
        this.oppda_def = oppda_def;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public float getxG_diff() {
        return xG_diff;
    }

    public void setxG_diff(float xG_diff) {
        this.xG_diff = xG_diff;
    }

    public float getxGA_diff() {
        return xGA_diff;
    }

    public void setxGA_diff(float xGA_diff) {
        this.xGA_diff = xGA_diff;
    }

    public float getXpts_diff() {
        return xpts_diff;
    }

    public void setXpts_diff(float xpts_diff) {
        this.xpts_diff = xpts_diff;
    }
}
