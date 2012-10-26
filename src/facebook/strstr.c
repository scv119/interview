int strcmp(const char　*s, const char *t)
{
    assert(s != NULL && t != NULL);
    while(*s && *t && *s == *t) {
        s ++;
        t ++;
    }

    return (*s - *t);
}

char *strstr(const char* src, const char* str) {
    assert(src != NULL　&& str != NULL);
    const char* s = src;
    const char* t = str;
    for(; *src != '\0'; src ++) {
        for(s = src, t = str; *t != '\0' && *s == *t; s ++, t ++);
        if(*t == 0)
            return (char*) src;
    }
    return NULL;
}

size_t strlen(const char* str) {
    assert(str != NULL);
    size_t len = 0;
    while( *str != '\0') {
        str ++; len ++;
    }
    return len;
}

char * strcpy(const char* source, char* dest) {
    if(source == dest)
        return dest;
    assert(source != NULL && dest != NULL);
    char *add = dest;
    while((*dest++ = *source++));
    return add;
}