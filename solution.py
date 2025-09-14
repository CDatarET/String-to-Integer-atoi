class Solution(object):
    def myAtoi(self, s):
        """
        :type s: str
        :rtype: int
        """
        s = s.strip()
        ns = ""
        start = False

        for i in range(len(s)):
            if(start and (s[i] == "-" or s[i] == "+")):
                break

            if(s[i] == "-"):
                if(start):
                    break
                start = True
                ns = ns + s[i]
                continue

            if(s[i] == "+"):
                if(start):
                    break
                else:
                    start = True
                    continue

            if(s[i].isdecimal()):
                ns = ns + s[i]
                start = True
            else:
                break

        if(ns == "" or ns == "-"):
            return(0)
        if(int(ns) >= 2147483647):
            return(2147483647)
        if(int(ns) <= -2147483648):
            return(-2147483648)
        return(int(ns))
