package com.android.githubretrofit.database.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.orm.dsl.Table;

/**
 * {@author equa1s}
 */
@Table
public final class User implements Parcelable {

    @SerializedName("id") private Long githubId;
    @SerializedName("login") private String login;
    @SerializedName("avatar_url") private String avatarUrl;
    @SerializedName("gravatar_id") private String gravatarId;
    @SerializedName("url") private String url;
    @SerializedName("html_url") private String htmlUrl;
    @SerializedName("followers_url") private String followersUrl;
    @SerializedName("following_url") private String followingUrl;
    @SerializedName("gists_url") private String gistsUrl;
    @SerializedName("starred_url") private String starredUrl;
    @SerializedName("subscriptions_url") private String subscriptionsUrl;
    @SerializedName("organizations_url") private String organizationsUrl;
    @SerializedName("repos_url") private String reposUrl;
    @SerializedName("events_url") private String eventsUrl;
    @SerializedName("received_events_url") private String receivedEventsUrl;
    @SerializedName("type") private String type;
    @SerializedName("site_admin") private Boolean siteAdmin;
    @SerializedName("name") private String name;
    @SerializedName("company") private String company;
    @SerializedName("blog") private String blog;
    @SerializedName("location") private String location;
    @SerializedName("email") private String email;
    @SerializedName("hireable") private Boolean hireable;
    @SerializedName("bio") private String bio;
    @SerializedName("private_repos") private Integer privateRepos;
    @SerializedName("private_gists") private Integer privateGists;
    @SerializedName("followers") private Integer followers;
    @SerializedName("following") private Integer following;
    @SerializedName("created_at") private String createdAt;
    @SerializedName("updated_at") private String updatedAt;

    public User() {}

    public Long getGithubId() {
        return githubId;
    }

    public void setGithubId(Long githubId) {
        this.githubId = githubId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getGravatarId() {
        return gravatarId;
    }

    public void setGravatarId(String gravatarId) {
        this.gravatarId = gravatarId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getFollowersUrl() {
        return followersUrl;
    }

    public void setFollowersUrl(String followersUrl) {
        this.followersUrl = followersUrl;
    }

    public String getFollowingUrl() {
        return followingUrl;
    }

    public void setFollowingUrl(String followingUrl) {
        this.followingUrl = followingUrl;
    }

    public String getGistsUrl() {
        return gistsUrl;
    }

    public void setGistsUrl(String gistsUrl) {
        this.gistsUrl = gistsUrl;
    }

    public String getStarredUrl() {
        return starredUrl;
    }

    public void setStarredUrl(String starredUrl) {
        this.starredUrl = starredUrl;
    }

    public String getSubscriptionsUrl() {
        return subscriptionsUrl;
    }

    public void setSubscriptionsUrl(String subscriptionsUrl) {
        this.subscriptionsUrl = subscriptionsUrl;
    }

    public String getOrganizationsUrl() {
        return organizationsUrl;
    }

    public void setOrganizationsUrl(String organizationsUrl) {
        this.organizationsUrl = organizationsUrl;
    }

    public String getReposUrl() {
        return reposUrl;
    }

    public void setReposUrl(String reposUrl) {
        this.reposUrl = reposUrl;
    }

    public String getEventsUrl() {
        return eventsUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    public String getReceivedEventsUrl() {
        return receivedEventsUrl;
    }

    public void setReceivedEventsUrl(String receivedEventsUrl) {
        this.receivedEventsUrl = receivedEventsUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getSiteAdmin() {
        return siteAdmin;
    }

    public void setSiteAdmin(Boolean siteAdmin) {
        this.siteAdmin = siteAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getHireable() {
        return hireable;
    }

    public void setHireable(Boolean hireable) {
        this.hireable = hireable;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Integer getPrivateRepos() {
        return privateRepos;
    }

    public void setPrivateRepos(Integer privateRepos) {
        this.privateRepos = privateRepos;
    }

    public Integer getPrivateGists() {
        return privateGists;
    }

    public void setPrivateGists(Integer privateGists) {
        this.privateRepos = privateRepos;
    }

    public Integer getFollowers() {
        return followers;
    }

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    public Integer getFollowing() {
        return following;
    }

    public void setFollowing(Integer following) {
        this.following = following;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "githubId=" + githubId +
                ", login='" + login + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", gravatarId='" + gravatarId + '\'' +
                ", url='" + url + '\'' +
                ", htmlUrl='" + htmlUrl + '\'' +
                ", followersUrl='" + followersUrl + '\'' +
                ", followingUrl='" + followingUrl + '\'' +
                ", gistsUrl='" + gistsUrl + '\'' +
                ", starredUrl='" + starredUrl + '\'' +
                ", subscriptionsUrl='" + subscriptionsUrl + '\'' +
                ", organizationsUrl='" + organizationsUrl + '\'' +
                ", reposUrl='" + reposUrl + '\'' +
                ", eventsUrl='" + eventsUrl + '\'' +
                ", receivedEventsUrl='" + receivedEventsUrl + '\'' +
                ", type='" + type + '\'' +
                ", siteAdmin=" + siteAdmin +
                ", name='" + name + '\'' +
                ", company=" + company +
                ", blog=" + blog +
                ", location='" + location + '\'' +
                ", email='" + email + '\'' +
                ", hireable=" + hireable +
                ", bio=" + bio +
                ", privateRepos=" + privateRepos +
                ", privateGists=" + privateGists +
                ", followers=" + followers +
                ", following=" + following +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.githubId);
        dest.writeString(this.login);
        dest.writeString(this.avatarUrl);
        dest.writeString(this.gravatarId);
        dest.writeString(this.url);
        dest.writeString(this.htmlUrl);
        dest.writeString(this.followersUrl);
        dest.writeString(this.followingUrl);
        dest.writeString(this.gistsUrl);
        dest.writeString(this.starredUrl);
        dest.writeString(this.subscriptionsUrl);
        dest.writeString(this.organizationsUrl);
        dest.writeString(this.reposUrl);
        dest.writeString(this.eventsUrl);
        dest.writeString(this.receivedEventsUrl);
        dest.writeString(this.type);
        dest.writeValue(this.siteAdmin);
        dest.writeString(this.name);
        dest.writeString(this.company);
        dest.writeString(this.blog);
        dest.writeString(this.location);
        dest.writeString(this.email);
        dest.writeValue(this.hireable);
        dest.writeString(this.bio);
        dest.writeValue(this.privateRepos);
        dest.writeValue(this.privateGists);
        dest.writeValue(this.followers);
        dest.writeValue(this.following);
        dest.writeString(this.createdAt);
        dest.writeString(this.updatedAt);
    }

    protected User(Parcel in) {
        this.githubId = (Long) in.readValue(Long.class.getClassLoader());
        this.login = in.readString();
        this.avatarUrl = in.readString();
        this.gravatarId = in.readString();
        this.url = in.readString();
        this.htmlUrl = in.readString();
        this.followersUrl = in.readString();
        this.followingUrl = in.readString();
        this.gistsUrl = in.readString();
        this.starredUrl = in.readString();
        this.subscriptionsUrl = in.readString();
        this.organizationsUrl = in.readString();
        this.reposUrl = in.readString();
        this.eventsUrl = in.readString();
        this.receivedEventsUrl = in.readString();
        this.type = in.readString();
        this.siteAdmin = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.name = in.readString();
        this.company = in.readString();
        this.blog = in.readString();
        this.location = in.readString();
        this.email = in.readString();
        this.hireable = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.bio = in.readString();
        this.privateRepos = (Integer) in.readValue(Integer.class.getClassLoader());
        this.privateGists = (Integer) in.readValue(Integer.class.getClassLoader());
        this.followers = (Integer) in.readValue(Integer.class.getClassLoader());
        this.following = (Integer) in.readValue(Integer.class.getClassLoader());
        this.createdAt = in.readString();
        this.updatedAt = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
